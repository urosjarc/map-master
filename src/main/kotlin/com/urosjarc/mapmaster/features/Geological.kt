package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class GeologicalNode(
    val node: OsmNode,
    val type: GeologicalType
)

data class GeologicalWay(
    val way: OsmWay,
    val type: GeologicalType
)

data class GeologicalRel(
    val rel: OsmRel,
    val type: GeologicalType
)

data class GeologicalFeatures(
    val nodes: MutableList<GeologicalNode> = mutableListOf(),
    val ways: MutableList<GeologicalWay> = mutableListOf(),
    val rels: MutableList<GeologicalRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["geological"]
        val type = GeologicalType.entries.firstOrNull { it.value == enumValue }
            ?: GeologicalType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(GeologicalNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(GeologicalRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(GeologicalWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class GeologicalType(val value: String) {
    MORAINE("moraine"),                 // Any accumulation of unconsolidated rock debris previously carried by a glacier
    OUTCROP("outcrop"),                 // A place where the bedrock or superficial deposits previously covered under the soil have become locally exposed
    VOLCANIC_CALDERA_RIM("volcanic_caldera_rim"), // The crater (caldera) of a volcano.
    FAULT("fault"),                     // Fracture between two moving rock-masses
    PALAEONTOLOGICAL_SITE("palaeontological_site"), // A place with fossils.
    VOLCANIC_LAVA_FIELD("volcanic_lava_field"), // An area with volcanic lava on the ground.
    VOLCANIC_VENT("volcanic_vent"),     // A hole through which the lava erupts.
    GLACIAL_ERRATIC("glacial_erratic"), // A boulder deposited by a glacier.
    ROCK_GLACIER("rock_glacier"),       // Rock glaciers are mixtures of rock and ice that move slowly downhill when active
    GIANTS_KETTLE("giants_kettle"),     // A regular hole in a rock created by the rotation of stones in the bed of a stream.
    METEOR_CRATER("meteor_crater"),     // A crater formed by the impact of a meteor.
    HOODOO("hoodoo"),                   // A column of rock with a hat
    COLUMNAR_JOINTING("columnar_jointing"), // Several hexagonal columns of rock
    OTHER("other")
}
