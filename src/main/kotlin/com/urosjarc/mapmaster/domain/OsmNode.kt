package com.urosjarc.mapmaster.domain

data class OsmNode(
    val id: Long,
    val lat: Double,
    val lon: Double,
    val tags: Map<String, String>
)
