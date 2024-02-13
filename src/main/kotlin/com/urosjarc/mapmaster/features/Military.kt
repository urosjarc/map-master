package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class MilitaryNode(
    val node: OsmNode,
    val type: MilitaryType
)

data class MilitaryWay(
    val way: OsmWay,
    val type: MilitaryType
)

data class MilitaryRel(
    val rel: OsmRel,
    val type: MilitaryType
)

data class MilitaryFeatures(
    val nodes: MutableList<MilitaryNode> = mutableListOf(),
    val ways: MutableList<MilitaryWay> = mutableListOf(),
    val rels: MutableList<MilitaryRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["military"]
        val type = MilitaryType.entries.firstOrNull { it.value == enumValue }
            ?: MilitaryType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(MilitaryNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(MilitaryRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(MilitaryWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class MilitaryType(val value: String) {
    ACADEMY("academy"),                 // A training establishment for military service members
    AIRFIELD("airfield"),               // A place where military planes take off and land.
    BASE("base"),                       // A facility where military personnel and equipment are based.
    BUNKER("bunker"),                   // A building reinforced to withstand attack
    BARRACKS("barracks"),               // Buildings where military personnel live and sleep
    CHECKPOINT("checkpoint"),           // Place where civilian visitors and vehicles will be checked by a military authority.
    DANGER_AREA("danger_area"),         // A danger area is a restricted area posing a threat to life or property.
    NUCLEAR_EXPLOSION_SITE("nuclear_explosion_site"), // Nuclear weapons test site
    OBSTACLE_COURSE("obstacle_course"), // A military obstacle course: a series of challenging physical obstructions an individual or team must navigate usually while being timed
    OFFICE("office"),                   // Military offices, e.g. general staff office, military recruitment office etc
    RANGE("range"),                     // Where military personnel practice with their weapons (firing, bombing, artillery, …)
    SCHOOL("school"),                   // A school for children run as part of a country's military
    TRAINING_AREA("training_area"),     // A military training area/proving ground
    TRENCH("trench"),                   // A military trench: an excavation in the ground that is generally deeper than it is wide, dug into the ground as a barrier for military purposes (e.g. trench warfare)
    OTHER("other")
}
