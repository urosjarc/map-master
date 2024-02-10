package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.OsmFeature
import com.urosjarc.mapmaster.OsmNode
import com.urosjarc.mapmaster.OsmRel
import com.urosjarc.mapmaster.OsmWay

/**
 * This file is auto generated!
 */

data class MaxaxleloadNode(
    val node: OsmNode,
    val type: MaxaxleloadType
)

data class MaxaxleloadWay(
    val way: OsmWay,
    val type: MaxaxleloadType
)

data class MaxaxleloadRel(
    val rel: OsmRel,
    val type: MaxaxleloadType
)

data class MaxaxleloadFeatures(
    val nodes: MutableList<MaxaxleloadNode> = mutableListOf(),
    val ways: MutableList<MaxaxleloadWay> = mutableListOf(),
    val rels: MutableList<MaxaxleloadRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["maxaxleload"]
        val type = MaxaxleloadType.entries.firstOrNull { it.value == enumValue }
            ?: MaxaxleloadType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(MaxaxleloadNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(MaxaxleloadRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(MaxaxleloadWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class MaxaxleloadType(val value: String) {
    WEIGHT("Weight"),                   // The legal maximum axleload – units other than tonnes should be explicit
    OTHER("other")
}
