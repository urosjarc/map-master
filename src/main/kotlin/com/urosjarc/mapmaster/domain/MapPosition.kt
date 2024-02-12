package com.urosjarc.mapmaster.domain

import kotlin.math.absoluteValue
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

data class MapPosition(
    val lat: Double,
    val lon: Double,
) {
    fun toList(): List<Double> {
        return listOf(this.lat, this.lon)
    }
    fun distance(position: MapPosition): Double {
        val dLat = (position.lat - this.lat).absoluteValue
        return acos(sin(position.lat) * sin(this.lat) + cos(position.lat) * cos(this.lat) * cos(dLat)) * 6_371_001
    }
}
