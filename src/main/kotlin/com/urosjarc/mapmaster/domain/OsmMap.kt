package com.urosjarc.mapmaster.domain

import com.urosjarc.mapmaster.Utils
import com.urosjarc.mapmaster.exceptions.OsmException
import com.urosjarc.mapmaster.rules.CyclewayTypeSuitability
import com.urosjarc.mapmaster.rules.FootwayTypeSuitability
import com.urosjarc.mapmaster.rules.HighwayTypeSuitability
import java.util.*
import kotlin.math.absoluteValue

data class OsmMap(
    val minLat: Double,
    val minLon: Double,
    val maxLat: Double,
    val maxLon: Double
) {

    val features = OsmFeatures()
    private val street_to_feature = mutableMapOf<String, MutableList<OsmFeature>>()
    private val position_to_street = mutableMapOf<MapVector, OsmNode>()

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

    fun searchClosestStreets(position: MapVector, radius: Float = 100f): List<MapMatch> {
        val matches = mutableListOf<MapMatch>()
        this.position_to_street.forEach { (pos, node) ->
            val distance = position.distance(vector = pos)
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

    fun createRoute(nodes: List<OsmNode>): List<OsmRouteNode> {

        val routeNodes = mutableListOf(
            OsmRouteNode(
                turnAngle = 0.0,
                address = nodes.first().address,
                vector = nodes.first().position,
                description = "Start your journey..."
            )
        )

        var traveledDistance = 0.0
        for (i in 1..<nodes.size - 1) {
            val preNode = nodes[i - 1]
            val curNode = nodes[i]
            val nextNode = nodes[i + 1]

            traveledDistance += preNode.position.distance(curNode.position)
            val firstMove = curNode.position.minus(preNode.position)
            val secondMove = nextNode.position.minus(curNode.position)

            val turnAngle = firstMove.angle(secondMove)
            var description: String? = null

            val preName = preNode.parents.first().tags["name"]
            val curName = curNode.parents.first().tags["name"]

            val angle = turnAngle.absoluteValue
            if (angle > 45) {
                description = "After ${traveledDistance.toInt()} meters turn"
                description += """ ${angle.toInt()}deg to the """
                description += if (turnAngle < 0) "left" else "right"
                if (curName != preName) {
                    if (curName == null)
                        description += " onto unknown street"
                    else {
                        val surface = curNode.parents.first().tags["surface"]
                        val type = curNode.parents.first().tags["highway"]
                        description += " onto '$curName' street (type: $type, surface: $surface)"
                    }
                }


                traveledDistance = 0.0
            }

            routeNodes.add(
                OsmRouteNode(
                    turnAngle = turnAngle,
                    address = curNode.address,
                    vector = curNode.position,
                    description = description
                )
            )
        }

        routeNodes.add(
            OsmRouteNode(
                turnAngle = 0.0,
                address = nodes.last().address,
                vector = nodes.last().position,
                description = "You finished your journey..."
            )
        )

        return routeNodes
    }

    fun searchShortestTransitWay(
        start: MapVector,
        finish: MapVector,
        vehicle: OsmVehicle,
        suitability: OsmSuitability
    ): List<OsmRouteNode> {

        //Get search space
        val nodes = this.getTransitWays(vehicle = vehicle, suitability = suitability).flatMap { it.nodes }

        //Get starting and end node
        var startNode: OsmNode = nodes[0]
        var finishNode: OsmNode = startNode

        var minStartDist = Double.MAX_VALUE
        var minFinishDist = Double.MAX_VALUE

        //Cost of cheepest path
        val gScore = mutableMapOf<OsmNode, Double>()
        val fScore = mutableMapOf<OsmNode, Double>()

        //Search travel space for closest end and start node
        var numNodes = 0
        nodes.forEach { node ->
            gScore[node] = Double.POSITIVE_INFINITY
            fScore[node] = Double.POSITIVE_INFINITY

            numNodes++
            val toStartDist = start.distance(vector = node.position)
            val toFinishDist = finish.distance(vector = node.position)
            if (toStartDist < minStartDist) {
                startNode = node
                minStartDist = toStartDist
            }
            if (toFinishDist < minFinishDist) {
                finishNode = node
                minFinishDist = toFinishDist
            }
        }

        //Cost of cheepest path
        gScore[startNode] = 0.0
        fScore[startNode] = this.costEstimation(start = startNode, end = finishNode, vehicle = vehicle)

        //Weighted A* algorithm
        val discoveredNodes = PriorityQueue<OsmNode>(numNodes, compareBy { fScore[it]!! })
        val cameFrom = mutableMapOf<OsmNode, OsmNode>()

        //Start discovering node
        discoveredNodes.add(startNode)

        //Traverse search space
        while (discoveredNodes.isNotEmpty()) {
            var current = discoveredNodes.remove()
            //If found end node backtrace the solution
            if (current == finishNode) {
                val route = mutableListOf(current)
                while (cameFrom.contains(key = current)) {
                    current = cameFrom[current]
                    route.add(0, current)
                }
                return this.createRoute(route)
            }

            current.siblings.forEach { sibling ->
                val tentativeScore = gScore.getOrPut(current) { Double.POSITIVE_INFINITY } + vehicle.cost(start = current, end = sibling)
                if (tentativeScore < gScore.getOrPut(sibling) { Double.POSITIVE_INFINITY }) {
                    cameFrom[sibling] = current
                    gScore[sibling] = tentativeScore
                    fScore[sibling] = tentativeScore + this.costEstimation(start = startNode, end = finishNode, vehicle = vehicle)
                    if (!discoveredNodes.contains(sibling)) {
                        discoveredNodes.add(sibling)
                    }
                }
            }

        }

        throw OsmException("End node was not found in search space")
    }
}
