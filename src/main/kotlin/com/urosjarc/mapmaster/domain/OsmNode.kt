package com.urosjarc.mapmaster.domain

data class OsmNode(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val lat: Float,
    val lon: Float,
) : OsmFeature
