package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class HistoricNode(
    val node: OsmNode,
    val type: HistoricType
)

data class HistoricWay(
    val way: OsmWay,
    val type: HistoricType
)

data class HistoricRel(
    val rel: OsmRel,
    val type: HistoricType
)

data class HistoricFeatures(
    val nodes: MutableList<HistoricNode> = mutableListOf(),
    val ways: MutableList<HistoricWay> = mutableListOf(),
    val rels: MutableList<HistoricRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["historic"]
        val type = HistoricType.entries.firstOrNull { it.value == enumValue }
            ?: HistoricType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(HistoricNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(HistoricRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(HistoricWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class HistoricType(val value: String) {
    AIRCRAFT("aircraft"),               // A decommissioned aircraft which generally remains in one place.
    ANCHOR("anchor"),                   // A historic/retired anchor. Usually found in historic maritime areas.
    AQUEDUCT("aqueduct"),               // A historic structure to convey water
    ARCHAEOLOGICAL_SITE("archaeological_site"), // A place in which evidence of past activity is preserved.
    BATTLEFIELD("battlefield"),         // The site of a battle or military skirmish in the past.
    BOMB_CRATER("bomb_crater"),         // A bomb crater
    BOUNDARY_STONE("boundary_stone"),   // A historic physical marker that identifies a boundary
    BUILDING("building"),               // Unspecified historic building.
    CANNON("cannon"),                   // A historic/retired cannon. Usually found on forts or battlefields.
    CASTLE("castle"),                   // Used for various kinds of castles, palaces, fortresses, manors, stately homes, kremlins, shiros and other.
    CASTLE_WALL("castle_wall"),         // A fortification surrounding the bailey of a castle
    CATTLE_CRUSH("cattle_crush"),
    CHARCOAL_PILE("charcoal_pile"),     // Historic site of a charcoal pile. Often still in good condition in hilly forest areas.
    CHURCH("church"),                   // A church with a historical value.
    CITY_GATE("city_gate"),             // A city gate within a city wall
    CITYWALLS("citywalls"),             // A citywall is a fortification used to defend a city.
    CREAMERY("creamery"),               // A creamery is an industrial building where butter and sometimes cheese or ice-cream were made from milk. For rural communities, it also served as a social gathering point.
    DISTRICT("district"),               // A designated historic district.
    FARM("farm"),                       // A historical farm, kept in its original state.
    FORT("fort"),                       // A military fort, a stand-alone defensive structure which differs from a castle in that there is no permanent residence.
    GALLOWS("gallows"),                 // remains of a gallows
    HOUSE("house"),                     // A historic house.
    HIGHWATER_MARK("highwater_mark"),   // A marker indicating a past flood or high water.
    LOCOMOTIVE("locomotive"),           // A decommissioned locomotive which generally remains in one place
    MACHINE("machine"),                 // A historic machine
    MANOR("manor"),                     // Historic manors/mansions having different use today
    MEMORIAL("memorial"),               // Small memorials, usually remembering special persons, people who lost their lives in the wars, past events or missing places.
    MILESTONE("milestone"),             // A historic marker that shows the distance to important destinations
    MILLSTONE("millstone"),             // A large round stone used for grinding grain or other materials.
    MONASTERY("monastery"),             // Building/place that is a historically significant monastery.
    MONUMENT("monument"),               // A memorial object, which is especially large, built to remember, show respect to a person or group of people or to commemorate an event.
    MOSQUE("mosque"),                   // A mosque with a historical and archaeological value.
    OGHAM_STONE("ogham_stone"),         // A stone with an Ogham script on it. They are most commonly found in Ireland as free standing stones, lying on the ground, recycled in buildings such as churches or as artefacts in museums.
    OPTICAL_TELEGRAPH("optical_telegraph"), // Semaphore system
    PILLORY("pillory"),                 // A pillory.
    RAILWAY_CAR("railway_car"),         // A decommissioned railway car which generally remains in one place
    ROAD("road"),                       // A road or street that is of historical importance.
    RUINS("ruins"),                     // Remains of structures that were once complete, but have fallen into partial or complete disrepair.
    RUNE_STONE("rune_stone"),           // Stones, boulders or bedrock with historical runic inscriptions.
    SHIELING("shieling"),               // An abandoned mountain pasture
    SHIP("ship"),                       // A decommissioned ship/submarine which generally remains in one place
    STEĆAK("stećak"),                   // Specifies megalithic gravestone from medieval Bosnia.
    STONE("stone"),                     // A stone shaped or placed by man with historical value.
    TANK("tank"),                       // A decommissioned tank which generally remains in one place
    TEMPLE("temple"),                   // An ancient pagan temple in_situ and in various degree of preservation, such as Ziggurat, Egyptian temple, Mithraeum, Erechtheion, Buddhist, Meso-American and other ancient religious and rituals' temples, with a historical and archaeological value.
    TOMB("tomb"),                       // A structure where somebody has been buried.
    TOWER("tower"),                     // This property distinguishes a tower as historic
    VEHICLE("vehicle"),                 // A decommissioned vehicle which generally remains in one place
    WAYSIDE_CROSS("wayside_cross"),     // A historical cross along a way, symbol of christian faith.
    WAYSIDE_SHRINE("wayside_shrine"),   // A shrine often showing a religious depiction. Tag is used also for modern shrines.
    WRECK("wreck"),                     // A nautical craft that has been sunk or destroyed.
    YES("yes"),                         // Used to add the historic significance of the objects described by other tags.
    OTHER("other")
}
