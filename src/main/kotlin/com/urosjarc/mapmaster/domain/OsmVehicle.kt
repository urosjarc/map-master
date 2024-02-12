package com.urosjarc.mapmaster.domain

data class OsmVehicle(
    val maxSpeed: Float,
    val width: Float,
    val height: Float,
    val type: Type
) {
    fun cost(start: OsmNode, end: OsmNode): Double {
        //Calculate accurate money cost to go from the start to the end node
        //Use elevated cartesian distance, road type etc...
        return start.position.distance(end.position)
    }

    enum class Type { BODY, HORSE, BICYCLE, MOPED, MOTORCYCLE, CAR, BUS, TRACTOR, TRAIN }
}
