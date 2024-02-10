package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.OsmFeature
import com.urosjarc.mapmaster.OsmNode
import com.urosjarc.mapmaster.OsmRel
import com.urosjarc.mapmaster.OsmWay

/**
 * This file is auto generated!
 */

data class BuswayNode(
    val node: OsmNode,
    val type: BuswayType
)

data class BuswayWay(
    val way: OsmWay,
    val type: BuswayType
)

data class BuswayRel(
    val rel: OsmRel,
    val type: BuswayType
)

data class BuswayFeatures(
    val nodes: MutableList<BuswayNode> = mutableListOf(),
    val ways: MutableList<BuswayWay> = mutableListOf(),
    val rels: MutableList<BuswayRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["busway"]
        val type = BuswayType.entries.firstOrNull { it.value == enumValue }
            ?: BuswayType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(BuswayNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(BuswayRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(BuswayWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class BuswayType(val value: String) {
    LANE("lane"),                       // Bus lane on both sides of the road. (See also: Parallel scheme for bus/psv lane tagging lanes:bus=* / lanes:psv=*)
    OTHER("other")
}
