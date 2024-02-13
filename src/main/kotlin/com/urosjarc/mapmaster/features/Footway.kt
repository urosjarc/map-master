package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class FootwayNode(
    val node: OsmNode,
    val type: FootwayType
)

data class FootwayWay(
    val way: OsmWay,
    val type: FootwayType
)

data class FootwayRel(
    val rel: OsmRel,
    val type: FootwayType
)

data class FootwayFeatures(
    val nodes: MutableList<FootwayNode> = mutableListOf(),
    val ways: MutableList<FootwayWay> = mutableListOf(),
    val rels: MutableList<FootwayRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["footway"]
        val type = FootwayType.entries.firstOrNull { it.value == enumValue }
            ?: FootwayType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(FootwayNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(FootwayRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(FootwayWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class FootwayType(val value: String) {
    SIDEWALK("sidewalk"),               // Sidewalk that runs typically along residential road. Use in combination with highway=footway or highway=path
    CROSSING("crossing"),               // Crosswalk that connects two sidewalks on the opposite side of the road. Often recognized by painted markings on the road, road sign or traffic lights. Use in combination with highway=footway or highway=path. Useful information is presence of tactile_paving=*, wheelchair=* suitability and kerb=* represented as a node on the crosswalk way.
    OTHER("other")
}
