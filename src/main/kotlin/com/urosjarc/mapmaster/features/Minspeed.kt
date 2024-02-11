package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class MinspeedNode(
    val node: OsmNode,
    val type: MinspeedType
)

data class MinspeedWay(
    val way: OsmWay,
    val type: MinspeedType
)

data class MinspeedRel(
    val rel: OsmRel,
    val type: MinspeedType
)

data class MinspeedFeatures(
    val nodes: MutableList<MinspeedNode> = mutableListOf(),
    val ways: MutableList<MinspeedWay> = mutableListOf(),
    val rels: MutableList<MinspeedRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["minspeed"]
        val type = MinspeedType.entries.firstOrNull { it.value == enumValue }
            ?: MinspeedType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(MinspeedNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(MinspeedRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(MinspeedWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class MinspeedType(val value: String) {
    SPEED("Speed"),                     // Minimum speed – units other than km/h should be explicit
    OTHER("other")
}
