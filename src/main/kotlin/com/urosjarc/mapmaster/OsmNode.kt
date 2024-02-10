package com.urosjarc.mapmaster

data class OsmNode(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),

    val lat: Float,
    val lon: Float,
) : OsmObj
