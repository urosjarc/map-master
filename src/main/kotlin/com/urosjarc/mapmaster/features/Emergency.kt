package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class EmergencyNode(
    val node: OsmNode,
    val type: EmergencyType
)

data class EmergencyWay(
    val way: OsmWay,
    val type: EmergencyType
)

data class EmergencyRel(
    val rel: OsmRel,
    val type: EmergencyType
)

data class EmergencyFeatures(
    val nodes: MutableList<EmergencyNode> = mutableListOf(),
    val ways: MutableList<EmergencyWay> = mutableListOf(),
    val rels: MutableList<EmergencyRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["emergency"]
        val type = EmergencyType.entries.firstOrNull { it.value == enumValue }
            ?: EmergencyType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(EmergencyNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(EmergencyRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(EmergencyWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class EmergencyType(val value: String) {
    AMBULANCE_STATION("ambulance_station"), // A ambulance station is a structure or other area set aside for storage of ambulance vehicles, medical equipment, personal protective equipment, and other medical supplies.
    DEFIBRILLATOR("defibrillator"),     // Defibrillator (AED), an external and portable electronic device that diagnoses and can correct arrhythmia of the heart automatically.
    LANDING_SITE("landing_site"),       // Preselected flat area for a helicopter to land in an emergency situation
    EMERGENCY_WARD_ENTRANCE("emergency_ward_entrance"), // The entrance to an emergency ward.
    FIRE_SERVICE_INLET("fire_service_inlet"), // A inlet that allows the fire brigade pump water into a building
    FIRE_ALARM_BOX("fire_alarm_box"),   // A device used for notifying a fire department of a fire.
    FIRE_EXTINGUISHER("fire_extinguisher"), // An active fire protection device used to extinguish or control small fires, often in emergency situations.
    FIRE_HOSE("fire_hose"),             // A high-pressure hose used to carry water or other fire retardant (such as foam) to a fire to extinguish it.
    FIRE_HYDRANT("fire_hydrant"),       // An active fire protection measure, and a source of water provided in most urban, suburban, and rural areas with municipal water service to enable fire fighters to tap into the municipal water supply to assist in extinguishing a fire.
    WATER_TANK("water_tank"),           // A large water basin or tank for a fire department to take water
    SUCTION_POINT("suction_point"),     // A preferred point to pump water off a river or other waters for a fire department.
    LIFEGUARD("lifeguard"),             // A place where a lifeguard is on duty
    LIFE_RING("life_ring"),             // A floating ring to throw out to someone who is struggling in water.
    ASSEMBLY_POINT("assembly_point"),   // A designated (safe) place where people can gather or must report to during an emergency or a fire drill
    PHONE("phone"),                     // Emergency telephone
    SIREN("siren"),                     // A loud noise maker, such as an air raid siren or a tornado siren.
    DRINKING_WATER("drinking_water"),   // A facility that provides drinking water in emergency situations
    OTHER("other")
}
