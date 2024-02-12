package com.urosjarc.mapmaster.domain

data class OsmVehicle(
    val maxSpeed: Float,
    val width: Float,
    val height: Float,
    val type: Type
) {
    enum class Type { BODY, HORSE, BICYCLE, MOPED, MOTORCYCLE, CAR, BUS, TRACTOR, TRAIN }
}
