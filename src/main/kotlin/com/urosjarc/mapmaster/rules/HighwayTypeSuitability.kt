package com.urosjarc.mapmaster.rules

import com.urosjarc.mapmaster.domain.OsmSuitability
import com.urosjarc.mapmaster.domain.OsmVehicle
import com.urosjarc.mapmaster.features.HighwayType

object HighwayTypeSuitability {
    fun get(vehicle: OsmVehicle, type: HighwayType): OsmSuitability {
        return when (type) {
            HighwayType.MOTORWAY -> when (vehicle.type) {
                OsmVehicle.Type.BODY -> OsmSuitability.CATASTROFIC
                OsmVehicle.Type.HORSE -> OsmSuitability.CATASTROFIC
                OsmVehicle.Type.BICYCLE -> OsmSuitability.CATASTROFIC
                OsmVehicle.Type.MOPED -> OsmSuitability.BAD
                OsmVehicle.Type.MOTORCYCLE -> OsmSuitability.EXCELENT
                OsmVehicle.Type.CAR -> OsmSuitability.EXCELENT
                OsmVehicle.Type.BUS -> OsmSuitability.EXCELENT
                OsmVehicle.Type.TRACTOR -> OsmSuitability.BAD
                OsmVehicle.Type.TRAIN -> OsmSuitability.IMPOSIBLE
            }

            HighwayType.TRUNK -> when (vehicle.type) {

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

            HighwayType.PRIMARY -> when (vehicle.type) {

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

            HighwayType.SECONDARY -> when (vehicle.type) {

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

            HighwayType.TERTIARY -> when (vehicle.type) {

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

            HighwayType.UNCLASSIFIED -> when (vehicle.type) {

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

            HighwayType.RESIDENTIAL -> when (vehicle.type) {

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

            HighwayType.MOTORWAY_LINK -> when (vehicle.type) {

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

            HighwayType.TRUNK_LINK -> when (vehicle.type) {

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

            HighwayType.PRIMARY_LINK -> when (vehicle.type) {

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

            HighwayType.SECONDARY_LINK -> when (vehicle.type) {

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

            HighwayType.TERTIARY_LINK -> when (vehicle.type) {

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

            HighwayType.LIVING_STREET -> when (vehicle.type) {

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

            HighwayType.SERVICE -> when (vehicle.type) {

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

            HighwayType.PEDESTRIAN -> when (vehicle.type) {
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

            HighwayType.TRACK -> when (vehicle.type) {

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

            HighwayType.BUS_GUIDEWAY -> when (vehicle.type) {

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

            HighwayType.ESCAPE -> when (vehicle.type) {

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

            HighwayType.RACEWAY -> when (vehicle.type) {

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

            HighwayType.ROAD -> when (vehicle.type) {

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

            HighwayType.BUSWAY -> when (vehicle.type) {

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

            HighwayType.FOOTWAY -> when (vehicle.type) {

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

            HighwayType.BRIDLEWAY -> when (vehicle.type) {

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

            HighwayType.STEPS -> when (vehicle.type) {

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

            HighwayType.CORRIDOR -> when (vehicle.type) {

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

            HighwayType.PATH -> when (vehicle.type) {

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

            HighwayType.VIA_FERRATA -> when (vehicle.type) {

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

            HighwayType.CYCLEWAY -> when (vehicle.type) {

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

            HighwayType.PROPOSED -> when (vehicle.type) {

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

            HighwayType.CONSTRUCTION -> when (vehicle.type) {

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

            HighwayType.BUS_STOP -> when (vehicle.type) {

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

            HighwayType.CROSSING -> when (vehicle.type) {

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

            HighwayType.CYCLIST_WAITING_AID -> when (vehicle.type) {

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

            HighwayType.ELEVATOR -> when (vehicle.type) {

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

            HighwayType.EMERGENCY_BAY -> when (vehicle.type) {

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

            HighwayType.EMERGENCY_ACCESS_POINT -> when (vehicle.type) {

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

            HighwayType.GIVE_WAY -> when (vehicle.type) {

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

            HighwayType.LADDER -> when (vehicle.type) {

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

            HighwayType.MILESTONE -> when (vehicle.type) {

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

            HighwayType.MINI_ROUNDABOUT -> when (vehicle.type) {

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

            HighwayType.MOTORWAY_JUNCTION -> when (vehicle.type) {

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

            HighwayType.PASSING_PLACE -> when (vehicle.type) {

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

            HighwayType.PLATFORM -> when (vehicle.type) {

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

            HighwayType.REST_AREA -> when (vehicle.type) {

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

            HighwayType.SERVICES -> when (vehicle.type) {

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

            HighwayType.SPEED_CAMERA -> when (vehicle.type) {

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

            HighwayType.STOP -> when (vehicle.type) {

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

            HighwayType.STREET_LAMP -> when (vehicle.type) {
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

            HighwayType.TOLL_GANTRY -> when (vehicle.type) {
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

            HighwayType.TRAFFIC_MIRROR -> when (vehicle.type) {
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

            HighwayType.TRAFFIC_SIGNALS -> when (vehicle.type) {
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

            HighwayType.TRAILHEAD -> when (vehicle.type) {
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

            HighwayType.TURNING_CIRCLE -> when (vehicle.type) {
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

            HighwayType.TURNING_LOOP -> when (vehicle.type) {
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

            HighwayType.OTHER -> when (vehicle.type) {
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
