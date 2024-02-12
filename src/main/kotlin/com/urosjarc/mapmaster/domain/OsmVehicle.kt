package com.urosjarc.mapmaster.domain

data class OsmVehicle(
    val maxSpeed: Float,
    val width: Float,
    val height: Float,
    val type: Type
) {
    companion object {
        val BODY = OsmVehicle(maxSpeed = 2.5f, width = 0.3f, height = 1.9f, type = Type.BODY)
        val CAR = OsmVehicle(maxSpeed = 180f, width = 3.0f, height = 1.7f, type = Type.CAR)
    }
    fun cost(start: OsmNode, end: OsmNode): Double {
        //Calculate accurate money cost to go from the start to the end node
        //Use elevated cartesian distance, road type etc...
        return start.position.distance(end.position)
    }

    enum class Type { BODY, HORSE, BICYCLE, MOPED, MOTORCYCLE, CAR, BUS, TRACTOR, TRAIN }
}
