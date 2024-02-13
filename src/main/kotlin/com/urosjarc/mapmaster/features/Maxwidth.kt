package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class MaxwidthNode(
    val node: OsmNode,
    val type: MaxwidthType
)

data class MaxwidthWay(
    val way: OsmWay,
    val type: MaxwidthType
)

data class MaxwidthRel(
    val rel: OsmRel,
    val type: MaxwidthType
)

data class MaxwidthFeatures(
    val nodes: MutableList<MaxwidthNode> = mutableListOf(),
    val ways: MutableList<MaxwidthWay> = mutableListOf(),
    val rels: MutableList<MaxwidthRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["maxwidth"]
        val type = MaxwidthType.entries.firstOrNull { it.value == enumValue }
            ?: MaxwidthType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(MaxwidthNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(MaxwidthRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(MaxwidthWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class MaxwidthType(val value: String) {
    WIDTH("Width"),                     // Width limit – units other than metres should be explicit
    OTHER("other")
}
