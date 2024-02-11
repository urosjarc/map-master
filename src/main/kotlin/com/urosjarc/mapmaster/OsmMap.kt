package com.urosjarc.mapmaster

data class OsmMap(
    val minLat: Float,
    val minLon: Float,
    val maxLat: Float,
    val maxLon: Float
) {

    val features = OsmFeatures()
    private val streets_to_features = mutableMapOf<String, MutableList<OsmFeature>>()
    private val positions_to_features = mutableMapOf<OsmPosition, MutableList<OsmNode>>()

    fun add(feature: OsmFeature): Boolean {
        val street = feature.obj.street()
        val houseNumber = feature.obj.houseNumber()

        // Add street mapping
        this.streets_to_features
            .getOrPut("$street $houseNumber", ::mutableListOf)
            .add(feature)

        // Add position mapping
        if (feature.objType == OsmFeature.Type.NODE) {
            val osmNode = feature.obj as OsmNode
            this.positions_to_features
                .getOrPut(osmNode.position, ::mutableListOf)
                .add(osmNode)
        }

        return this.features.add(feature = feature)
    }

    fun getStreetFeatures(name: String): MutableList<OsmFeature>? {
        return this.streets_to_features[name]
    }

    fun searchStreetName(query: String, limit: Int = 10): List<OsmMatch> =
        Utils.search(query = query, choices = this.streets_to_features.keys, limit = limit)

    fun searchClosestStreet(position: OsmPosition): List<OsmMatch> =
        val closest: OsmPosition = OsmPosition(lat = Float.MAX_VALUE, lon = Float.MAX_VALUE)
        val closestDistance: Float = Float.MAX_VALUE
        this.positions_to_features.forEach { position, nodes ->

        }
}
