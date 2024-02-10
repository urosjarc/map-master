package com.urosjarc.mapmaster.domain

open class OsmFeature(
    val obj: OsmObj,
    val objType: Type
) {
    enum class Type { NODE, RELATIONSHIP, WAY }
}
