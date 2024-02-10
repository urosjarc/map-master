package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.OsmFeature
import com.urosjarc.mapmaster.OsmNode
import com.urosjarc.mapmaster.OsmRel
import com.urosjarc.mapmaster.OsmWay

/**
 * This file is auto generated!
 */

data class WaterwayNode(
    val node: OsmNode,
    val type: WaterwayType
)

data class WaterwayWay(
    val way: OsmWay,
    val type: WaterwayType
)

data class WaterwayRel(
    val rel: OsmRel,
    val type: WaterwayType
)

data class WaterwayFeatures(
    val nodes: MutableList<WaterwayNode> = mutableListOf(),
    val ways: MutableList<WaterwayWay> = mutableListOf(),
    val rels: MutableList<WaterwayRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["waterway"]
        val type = WaterwayType.entries.firstOrNull { it.value == enumValue }
            ?: WaterwayType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(WaterwayNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(WaterwayRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(WaterwayWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class WaterwayType(val value: String) {
    RIVER("river"),                     // The linear flow of a river, in flow direction.
    RIVERBANK("riverbank"),             // Use of this tag is discouraged, see natural=water + water=river instead
    STREAM("stream"),                   // A naturally-forming waterway that is too narrow to be classed as a river.
    TIDAL_CHANNEL("tidal_channel"),     // A natural intertidal waterway in mangroves, salt marshes, and tidal flats with water flow in the direction of the tide.
    CANAL("canal"),                     // An artificial '''open flow''' waterway used to carry useful water for transportation, waterpower, or irrigation.
    DRAIN("drain"),                     // An artificial free flow waterway used for carrying superfluous water, usually lined with concrete.
    DITCH("ditch"),                     // A small man-made drainage waterway, usually unlined.
    PRESSURISED("pressurised"),         // An artificial waterway where water flows in a closed space without air
    FAIRWAY("fairway"),                 // A navigable route in a lake or sea, often marked by buoys or beacons.
    DOCK("dock"),                       // An enclosed area for ships or boats within which the height of the water can be managed, or a dry dock.
    BOATYARD("boatyard"),               // A place for constructing, repairing and storing vessels out of the water.
    DAM("dam"),                         // A barrier built across a river or stream to block and regulate the flow of the river.
    WEIR("weir"),                       // A barrier built across a river to control water speed and depth. Designed to let water flow over the top all the time or at least in specific conditions.
    WATERFALL("waterfall"),             // A place where water flows over a vertical drop or a series of drops in the course of a stream or river.
    LOCK_GATE("lock_gate"),             // A gate of a lock
    SOAKHOLE("soakhole"),               // The point at which a river or stream percolates into or through the soil
    TURNING_POINT("turning_point"),     // A place to turn the driving direction for vessels, where the boats are longer than the river/canal is wide.
    WATER_POINT("water_point"),         // A place to fill fresh water holding tanks of a boat.
    FUEL("fuel"),                       // A place to get fuel for boats
    OTHER("other")
}
