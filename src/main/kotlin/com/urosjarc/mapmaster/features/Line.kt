package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.OsmFeature
import com.urosjarc.mapmaster.OsmNode
import com.urosjarc.mapmaster.OsmRel
import com.urosjarc.mapmaster.OsmWay

/**
 * This file is auto generated!
 */

data class LineNode(
    val node: OsmNode,
    val type: LineType
)

data class LineWay(
    val way: OsmWay,
    val type: LineType
)

data class LineRel(
    val rel: OsmRel,
    val type: LineType
)

data class LineFeatures(
    val nodes: MutableList<LineNode> = mutableListOf(),
    val ways: MutableList<LineWay> = mutableListOf(),
    val rels: MutableList<LineRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["line"]
        val type = LineType.entries.firstOrNull { it.value == enumValue }
            ?: LineType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(LineNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(LineRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(LineWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class LineType(val value: String) {
    BUSBAR("busbar"),                   // Identifies a power line as a busbar, the central connection in a substation
    BAY("bay"),                         // A power line within a substation which connects a circuit to a busbar.
    OTHER("other")
}
