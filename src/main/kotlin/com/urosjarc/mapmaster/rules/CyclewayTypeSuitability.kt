package com.urosjarc.mapmaster.rules

import com.urosjarc.mapmaster.domain.OsmSuitability
import com.urosjarc.mapmaster.domain.OsmVehicle
import com.urosjarc.mapmaster.features.CyclewayType

object CyclewayTypeSuitability {

    fun get(vehicle: OsmVehicle, type: CyclewayType): OsmSuitability {
        return when (type) {
            CyclewayType.LANE -> when (vehicle.type) {
                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }

            CyclewayType.OPPOSITE -> when (vehicle.type) {
                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }

            CyclewayType.OPPOSITE_LANE -> when (vehicle.type) {

                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }

            CyclewayType.TRACK -> when (vehicle.type) {

                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }

            CyclewayType.OPPOSITE_TRACK -> when (vehicle.type) {

                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }

            CyclewayType.SHARE_BUSWAY -> when (vehicle.type) {

                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }

            CyclewayType.OPPOSITE_SHARE_BUSWAY -> when (vehicle.type) {

                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }

            CyclewayType.SHARED_LANE -> when (vehicle.type) {

                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }

            CyclewayType.OTHER -> when (vehicle.type) {

                OsmVehicle.Type.BODY -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.HORSE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BICYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOPED -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.CAR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.BUS -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRACTOR -> OsmSuitability.NEUTRAL
                OsmVehicle.Type.TRAIN -> OsmSuitability.NEUTRAL
            }
        }
    }
}
