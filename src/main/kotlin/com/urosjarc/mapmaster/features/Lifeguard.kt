package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class LifeguardNode(
    val node: OsmNode,
    val type: LifeguardType
)

data class LifeguardWay(
    val way: OsmWay,
    val type: LifeguardType
)

data class LifeguardRel(
    val rel: OsmRel,
    val type: LifeguardType
)

data class LifeguardFeatures(
    val nodes: MutableList<LifeguardNode> = mutableListOf(),
    val ways: MutableList<LifeguardWay> = mutableListOf(),
    val rels: MutableList<LifeguardRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["lifeguard"]
        val type = LifeguardType.entries.firstOrNull { it.value == enumValue }
            ?: LifeguardType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(LifeguardNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(LifeguardRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(LifeguardWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class LifeguardType(val value: String) {
    TOWER("tower"),                     // A tower used by lifeguard to watch and supervise swimmers in order to prevent drownings and other dangers.
    OTHER("other")
}
