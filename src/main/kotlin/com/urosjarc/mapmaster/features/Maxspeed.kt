package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.OsmFeature
import com.urosjarc.mapmaster.OsmNode
import com.urosjarc.mapmaster.OsmRel
import com.urosjarc.mapmaster.OsmWay

/**
 * This file is auto generated!
 */

data class MaxspeedNode(
    val node: OsmNode,
    val type: MaxspeedType
)

data class MaxspeedWay(
    val way: OsmWay,
    val type: MaxspeedType
)

data class MaxspeedRel(
    val rel: OsmRel,
    val type: MaxspeedType
)

data class MaxspeedFeatures(
    val nodes: MutableList<MaxspeedNode> = mutableListOf(),
    val ways: MutableList<MaxspeedWay> = mutableListOf(),
    val rels: MutableList<MaxspeedRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["maxspeed"]
        val type = MaxspeedType.entries.firstOrNull { it.value == enumValue }
            ?: MaxspeedType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(MaxspeedNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(MaxspeedRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(MaxspeedWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class MaxspeedType(val value: String) {
    SPEED("Speed"),                     // Maximum speed – units other than km/h should be explicit
    OTHER("other")
}
