package com.urosjarc.mapmaster.rules

import com.urosjarc.mapmaster.domain.OsmSuitability
import com.urosjarc.mapmaster.domain.OsmVehicle
import com.urosjarc.mapmaster.features.FootwayType

object FootwayTypeSuitability {
    fun get(vehicle: OsmVehicle, type: FootwayType): OsmSuitability {
        return when (type) {
            FootwayType.SIDEWALK -> when (vehicle.type) {
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

            FootwayType.CROSSING -> when (vehicle.type) {
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

            FootwayType.OTHER -> when (vehicle.type) {
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
