package com.urosjarc.mapmaster.domain

open class OsmFeature(
    open val obj: OsmObj,
    open val objType: Type
) {
    enum class Type { NODE, RELATIONSHIP, WAY }
}
