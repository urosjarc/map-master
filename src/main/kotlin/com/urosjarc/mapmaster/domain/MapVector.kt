package com.urosjarc.mapmaster.domain

import java.lang.Math.pow
import java.lang.Math.toDegrees
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sqrt

data class MapVector(
    var lat: Double,
    var lon: Double,
) {
    fun toMap(): Map<String, Double> = mapOf(
        this::lat.name to this.lat,
        this::lon.name to this.lon
    )

    fun minus(vector: MapVector): MapVector = MapVector(lat = this.lat - vector.lat, lon = this.lon - vector.lon)

    fun dot(vector: MapVector): Double = this.lat * vector.lat + this.lon * vector.lon

    val length get(): Double = sqrt(pow(this.lat, 2.0) + pow(this.lon, 2.0))

    fun angle(vector: MapVector): Double {
        val angle = toDegrees(acos(this.dot(vector) / (this.length * vector.length)))
        val cross = this.cross(vector = vector)
        return if (cross < 0) -angle else angle
    }

    fun cross(vector: MapVector): Double = this.lat * vector.lon - this.lon * vector.lat

    fun distance(vector: MapVector): Double {
        val lat1Rad = Math.toRadians(this.lat)
        val lat2Rad = Math.toRadians(vector.lat)
        val lon1Rad = Math.toRadians(this.lon)
        val lon2Rad = Math.toRadians(vector.lon)

        val x = (lon2Rad - lon1Rad) * cos((lat1Rad + lat2Rad) / 2)
        val y = (lat2Rad - lat1Rad)
        val distance: Double = sqrt(x * x + y * y) * 6_371_001

        return distance
    }
}
