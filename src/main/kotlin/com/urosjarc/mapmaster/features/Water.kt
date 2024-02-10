package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.OsmFeature
import com.urosjarc.mapmaster.OsmNode
import com.urosjarc.mapmaster.OsmRel
import com.urosjarc.mapmaster.OsmWay

/**
 * This file is auto generated!
 */

data class WaterNode(
    val node: OsmNode,
    val type: WaterType
)

data class WaterWay(
    val way: OsmWay,
    val type: WaterType
)

data class WaterRel(
    val rel: OsmRel,
    val type: WaterType
)

data class WaterFeatures(
    val nodes: MutableList<WaterNode> = mutableListOf(),
    val ways: MutableList<WaterWay> = mutableListOf(),
    val rels: MutableList<WaterRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["water"]
        val type = WaterType.entries.firstOrNull { it.value == enumValue }
            ?: WaterType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(WaterNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(WaterRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(WaterWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class WaterType(val value: String) {
    RIVER("river"),                     // The water covered area of a river
    OXBOW("oxbow"),                     // An oxbow lake
    CANAL("canal"),                     // The area covered by the water of a canal
    DITCH("ditch"),                     // The water covered area of a waterway=ditch - a simple artificial waterway serving as a barrier or for draining surrounding land.
    LOCK("lock"),                       // Water area of the lock chamber
    FISH_PASS("fish_pass"),             // Area of a fish pass for the fish to pass waterway dams or weirs. Should contain tag:waterway=fish_pass way inside.
    LAKE("lake"),                       // A natural or semi-natural body of relatively still fresh or salt water which is surrounded by land.
    RESERVOIR("reservoir"),             // An artificial lake which may be used to store water. Usually formed by a dam over a natural water course.
    POND("pond"),                       // A small body of standing water, man-made in most cases
    BASIN("basin"),                     // An area of land artificially graded to hold water.
    LAGOON("lagoon"),                   // A body of shallow sea water or brackish water separated from the sea by a barrier.
    STREAM_POOL("stream_pool"),         // A stream pool: a small but relatively deep collection of fresh water, occurring along a narrow stream
    REFLECTING_POOL("reflecting_pool"), // A shallow pool of water, undisturbed by fountain jets, for a calm reflective surface, often found in gardens, squares or at memorial sites
    MOAT("moat"),                       // A deep, wide defensive ditch, normally filled with water, dug to surround a fortified habitation.
    WASTEWATER("wastewater"),           // A clarifier or settling basin of a wastewater treatment plant.
    OTHER("other")
}
