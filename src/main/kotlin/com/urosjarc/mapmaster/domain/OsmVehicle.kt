package com.urosjarc.mapmaster.domain

data class OsmVehicle(
    val maxSpeed: Float,
    val width: Float,
    val height: Float,
    val type: Type
) {
    companion object {
        val BODY = OsmVehicle(maxSpeed = 2.5f, width = 0.3f, height = 1.9f, type = Type.BODY)
        val HORSE = OsmVehicle(maxSpeed = 40f, width = 1f, height = 2.6f, type = Type.HORSE)
        val BICYCLE = OsmVehicle(maxSpeed = 50f, width = 0.3f, height = 1.5f, type = Type.BICYCLE)
        val MOPED = OsmVehicle(maxSpeed = 45f, width = 0.3f, height = 1.5f, type = Type.MOPED)
        val MOTORCYCLE = OsmVehicle(maxSpeed = 240f, width = 0.3f, height = 1.5f, type = Type.MOTORCYCLE)
        val CAR = OsmVehicle(maxSpeed = 180f, width = 3.0f, height = 1.7f, type = Type.CAR)
        val BUS = OsmVehicle(maxSpeed = 100f, width = 5.0f, height = 4f, type = Type.BUS)
        val TRACTOR = OsmVehicle(maxSpeed = 60f, width = 4.0f, height = 4f, type = Type.TRACTOR)
        val TRAIN = OsmVehicle(maxSpeed = 120f, width = 4.0f, height = 4f, type = Type.TRAIN)
    }

    fun cost(start: OsmNode, end: OsmNode): Double {
        //Calculate accurate money cost to go from the start to the end node
        //Use elevated cartesian distance, road type etc...
        return start.position.distance(end.position)
    }

    enum class Type { BODY, HORSE, BICYCLE, MOPED, MOTORCYCLE, CAR, BUS, TRACTOR, TRAIN }
}
