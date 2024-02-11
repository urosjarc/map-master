package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.domain.*

data class OsmMap(
    val minLat: Double,
    val minLon: Double,
    val maxLat: Double,
    val maxLon: Double
) {

    val features = OsmFeatures()
    private val streets_to_features = mutableMapOf<String, MutableList<OsmFeature>>()
    private val positions_to_nodes = mutableMapOf<MapPosition, OsmNode>()

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
                this.positions_to_nodes[node.position] = node
            }
        }

        return this.features.add(feature = feature)
    }

    fun getStreetFeatures(name: String): MutableList<OsmFeature>? {
        return this.streets_to_features[name]
    }

    fun searchStreet(query: String, limit: Int = 10): List<MapMatch> =
        Utils.search(query = query, choices = this.streets_to_features.keys, limit = limit)

    fun searchClosestStreet(position: MapPosition, radius: Float = 100f): List<MapMatch> {
        var matches = mutableListOf<MapMatch>()
        this.positions_to_nodes.forEach { (pos, node) ->
            val distance = position.distance(position = pos)
            val address = node.address
            if (distance < radius && address != null) {
                matches.add(MapMatch(match = address, distance = distance))
            }
        }

        matches.sortBy { it.distance }

        return matches
    }
}
