package com.urosjarc.mapmaster.domain

class OsmNode(
    override val id: Long,
    override val tags: MutableMap<String, String>,

    val lat: Float,
    val lon: Float,
) : OsmObj
