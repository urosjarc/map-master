package com.urosjarc.mapmaster.domain

data class OsmRouteNode(
    val turnAngle: Double,
    val address: String?,
    val vector: MapVector,
    val description: String?
)
