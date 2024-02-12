package com.urosjarc.mapmaster.domain

import com.urosjarc.mapmaster.Utils
import com.urosjarc.mapmaster.exceptions.OsmException
import com.urosjarc.mapmaster.rules.CyclewayTypeSuitability
import com.urosjarc.mapmaster.rules.FootwayTypeSuitability
import com.urosjarc.mapmaster.rules.HighwayTypeSuitability
import java.util.*

data class OsmMap(
    val minLat: Double,
    val minLon: Double,
    val maxLat: Double,
    val maxLon: Double
) {

    val features = OsmFeatures()
    private val street_to_feature = mutableMapOf<String, MutableList<OsmFeature>>()
    private val position_to_street = mutableMapOf<MapPosition, OsmNode>()

    fun add(feature: OsmFeature): Boolean {
        val street = feature.obj.street
        val houseNumber = feature.obj.houseNumber

        // Add street mapping
        if (street != null) {
            this.street_to_feature
                .getOrPut(feature.obj.address!!, ::mutableListOf)
                .add(feature)
        }

        // Add position mapping
        if (feature.objType == OsmFeature.Type.NODE) {
            val node = feature.obj as OsmNode
            if (street != null && houseNumber != null) {
                this.position_to_street[node.position] = node
            }
        }

        return this.features.add(feature = feature)
    }

    /**
     * GETTING
     */
    fun getTransitWays(vehicle: OsmVehicle, suitability: OsmSuitability): List<OsmWay> {
        val suitableHighwayFeatures = this.features.highway.ways.filter {
            HighwayTypeSuitability.get(vehicle = vehicle, type = it.type).ordinal >= suitability.ordinal
        }.map { it.way }

        val suitableFootFeatures = this.features.footway.ways.filter {
            FootwayTypeSuitability.get(vehicle = vehicle, type = it.type).ordinal >= suitability.ordinal
        }.map { it.way }

        val suitableCyclewayFeatures = this.features.cycleway.ways.filter {
            CyclewayTypeSuitability.get(vehicle = vehicle, type = it.type).ordinal >= suitability.ordinal
        }.map { it.way }

        return suitableCyclewayFeatures + suitableFootFeatures + suitableHighwayFeatures
    }

    fun getPublicTransitWays(): List<OsmFeature> {
        TODO()
    }


    fun getStreetFeatures(name: String): MutableList<OsmFeature>? {
        return this.street_to_feature[name]
    }

    /**
     * SEARCHING
     */
    fun searchStreet(query: String, limit: Int = 10): List<MapMatch> =
        Utils.search(query = query, choices = this.street_to_feature.keys, limit = limit)

    fun searchClosestStreets(position: MapPosition, radius: Float = 100f): List<MapMatch> {
        var matches = mutableListOf<MapMatch>()
        this.position_to_street.forEach { (pos, node) ->
            val distance = position.distance(position = pos)
            val address = node.address
            if (distance < radius && address != null) {
                matches.add(MapMatch(match = address, distance = distance))
            }
        }

        matches.sortBy { it.distance }

        return matches
    }

    fun costEstimation(start: OsmNode, end: OsmNode, vehicle: OsmVehicle): Double {
        //TODO: Calculate cartesian distance with elevation data
        //TODO: Calculate node density, type, etc.. to approximate how long it would take to travel the air distance to finish
        return start.position.distance(end.position)
    }

    fun searchShortestTransitWay(
        start: MapPosition,
        end: MapPosition,
        vehicle: OsmVehicle,
        suitability: OsmSuitability
    ): MutableList<OsmNode> {

        //Get search space
        val ways = this.getTransitWays(vehicle = vehicle, suitability = suitability).toMutableList()

        //Get starting and end node
        var startNode: OsmNode = ways[0].nodes[0]
        var endNode: OsmNode = startNode

        var minStartDist = Double.MAX_VALUE
        var minEndDist = Double.MAX_VALUE

        //Search travel space for closest end and start node
        var numNodes = 0
        ways.forEach { way ->
            way.nodes.forEach { node ->
                numNodes++
                val toStartDist = start.distance(position = node.position)
                val toEndDist = end.distance(position = node.position)
                if (toStartDist < minStartDist) {
                    startNode = node
                    minStartDist = toStartDist
                }
                if (toEndDist < minEndDist) {
                    endNode = node
                    minEndDist = toEndDist
                }
            }
        }

        //Cost of cheepest path
        val gScore = mutableMapOf(startNode to 0.0)
        val fScore = mutableMapOf(startNode to this.costEstimation(start = startNode, end = endNode, vehicle = vehicle))

        //Weighted A* algorithm
        val discoveredNodes = PriorityQueue<OsmNode>(numNodes, compareBy { fScore[it]!! })
        val cameFrom = mutableMapOf<OsmNode, OsmNode>()


        //Traverse search space
        while (ways.isNotEmpty()) {
            var current = discoveredNodes.remove()
            //If found end node backtrace the solution
            if (current == endNode) {
                val route = mutableListOf(current)
                while (cameFrom.contains(key = current)) {
                    current = cameFrom[current]
                    route.add(0, current)
                }
                return route
            }

            current.siblings.forEach { sibling ->
                val siblingsGScore = gScore[current]!!
                val tentativeScore = siblingsGScore + vehicle.cost(start = current, end = sibling)
                if (tentativeScore < siblingsGScore) {
                    cameFrom[sibling] = current
                    gScore[sibling] = tentativeScore
                    fScore[sibling] = tentativeScore + this.costEstimation(start = startNode, end = endNode, vehicle = vehicle)
                    if (!discoveredNodes.contains(sibling)) {
                        discoveredNodes.add(sibling)
                    }
                }
            }

        }

        throw OsmException("End node was not found in search space")
    }
}
