package com.urosjarc.mapmaster

data class OsmFeature(
    val obj: OsmObj,
    val objType: Type
) {
    enum class Type { NODE, RELATIONSHIP, WAY }
}
