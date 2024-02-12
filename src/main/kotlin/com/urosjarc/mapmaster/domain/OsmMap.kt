package com.urosjarc.mapmaster.domain

import com.urosjarc.mapmaster.Utils
import com.urosjarc.mapmaster.rules.CyclewayTypeSuitability
import com.urosjarc.mapmaster.rules.FootwayTypeSuitability
import com.urosjarc.mapmaster.rules.HighwayTypeSuitability

data class OsmMap(
    val minLat: Double,
    val minLon: Double,
    val maxLat: Double,
    val maxLon: Double
) {

    val features = OsmFeatures()
    private val streets_to_features = mutableMapOf<String, MutableList<OsmFeature>>()
    private val positions_to_streets = mutableMapOf<MapPosition, OsmNode>()


    fun add(feature: OsmFeature): Boolean {
        val street = feature.obj.street
        val houseNumber = feature.obj.houseNumber

        // Add street mapping
        if (street != null) {
            this.streets_to_features
                .getOrPut(feature.obj.address!!, ::mutableListOf)
                .add(feature)
        }

        // Add position mapping
        if (feature.objType == OsmFeature.Type.NODE) {
            val node = feature.obj as OsmNode
            if (street != null && houseNumber != null) {
                this.positions_to_streets[node.position] = node
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
        return this.streets_to_features[name]
    }

    /**
     * SEARCHING
     */
    fun searchStreet(query: String, limit: Int = 10): List<MapMatch> =
        Utils.search(query = query, choices = this.streets_to_features.keys, limit = limit)

    fun searchClosestStreets(position: MapPosition, radius: Float = 100f): List<MapMatch> {
        var matches = mutableListOf<MapMatch>()
        this.positions_to_streets.forEach { (pos, node) ->
            val distance = position.distance(position = pos)
            val address = node.address
            if (distance < radius && address != null) {
                matches.add(MapMatch(match = address, distance = distance))
            }
        }

        matches.sortBy { it.distance }

        return matches
    }

    fun searchShortestPath(start: MapPosition, end: MapPosition) {

    }
}
