package com.urosjarc.mapmaster

data class OsmMap(
    val minLat: Float,
    val minLon: Float,
    val maxLat: Float,
    val maxLon: Float
) {

    val features = OsmFeatures()
}
