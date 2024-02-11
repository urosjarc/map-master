package com.urosjarc.mapmaster.domain

data class OsmFeature(
    val obj: OsmObj,
    val objType: Type
) {
    enum class Type { NODE, RELATIONSHIP, WAY }
}
