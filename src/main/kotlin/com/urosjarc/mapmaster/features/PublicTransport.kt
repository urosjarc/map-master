package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class PublicTransportNode(
    val node: OsmNode,
    val type: PublicTransportType
)

data class PublicTransportWay(
    val way: OsmWay,
    val type: PublicTransportType
)

data class PublicTransportRel(
    val rel: OsmRel,
    val type: PublicTransportType
)

data class PublicTransportFeatures(
    val nodes: MutableList<PublicTransportNode> = mutableListOf(),
    val ways: MutableList<PublicTransportWay> = mutableListOf(),
    val rels: MutableList<PublicTransportRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["public_transport"]
        val type = PublicTransportType.entries.firstOrNull { it.value == enumValue }
            ?: PublicTransportType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(PublicTransportNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(PublicTransportRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(PublicTransportWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class PublicTransportType(val value: String) {
    STOP_POSITION("stop_position"),     // The position on the street or rails where a public transport vehicle stops.
    PLATFORM("platform"),               // The place where passengers are waiting for the public transport vehicles.
    STATION("station"),                 // A station is an area designed to access public transport.
    STOP_AREA("stop_area"),             // A relation that contains all elements of a train, subway, monorail, tram, bus, trolleybus, aerialway, or ferry stop.
    STOP_AREA_GROUP("stop_area_group"),
    OTHER("other")
}
