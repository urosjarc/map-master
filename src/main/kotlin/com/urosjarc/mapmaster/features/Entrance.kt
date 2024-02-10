package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.OsmFeature
import com.urosjarc.mapmaster.OsmNode
import com.urosjarc.mapmaster.OsmRel
import com.urosjarc.mapmaster.OsmWay

/**
 * This file is auto generated!
 */

data class EntranceNode(
    val node: OsmNode,
    val type: EntranceType
)

data class EntranceWay(
    val way: OsmWay,
    val type: EntranceType
)

data class EntranceRel(
    val rel: OsmRel,
    val type: EntranceType
)

data class EntranceFeatures(
    val nodes: MutableList<EntranceNode> = mutableListOf(),
    val ways: MutableList<EntranceWay> = mutableListOf(),
    val rels: MutableList<EntranceRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["entrance"]
        val type = EntranceType.entries.firstOrNull { it.value == enumValue }
            ?: EntranceType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(EntranceNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(EntranceRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(EntranceWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class EntranceType(val value: String) {
    YES("yes"),                         // An entrance in a building. Replaces the deprecated tag building=entrance.
    OTHER("other")
}
