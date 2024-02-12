package com.urosjarc.mapmaster.domain

data class MapMatch(
    val match: String,
    val distance: Double
) {
    fun toMap(): Map<String, Any> = mapOf(
        this::match.name to this.match,
        this::distance.name to this.distance
    )
}
