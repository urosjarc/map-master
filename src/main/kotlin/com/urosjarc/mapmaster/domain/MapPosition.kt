package com.urosjarc.mapmaster.domain

import kotlin.math.absoluteValue
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

data class MapPosition(
    var lat: Double,
    var lon: Double,
) {
    fun toMap(): Map<String, Double> = mapOf(
        this::lat.name to this.lat,
        this::lon.name to this.lon
    )

    fun distance(position: MapPosition): Double {
        val dLat = position.lat - this.lat
        return (acos(sin(position.lat) * sin(this.lat) + cos(position.lat) * cos(this.lat) * cos(dLat)) * 6_371_001).absoluteValue
    }
}
