package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.OsmFeature
import com.urosjarc.mapmaster.OsmNode
import com.urosjarc.mapmaster.OsmRel
import com.urosjarc.mapmaster.OsmWay

/**
 * This file is auto generated!
 */

data class TelecomNode(
    val node: OsmNode,
    val type: TelecomType
)

data class TelecomWay(
    val way: OsmWay,
    val type: TelecomType
)

data class TelecomRel(
    val rel: OsmRel,
    val type: TelecomType
)

data class TelecomFeatures(
    val nodes: MutableList<TelecomNode> = mutableListOf(),
    val ways: MutableList<TelecomWay> = mutableListOf(),
    val rels: MutableList<TelecomRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["telecom"]
        val type = TelecomType.entries.firstOrNull { it.value == enumValue }
            ?: TelecomType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(TelecomNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(TelecomRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(TelecomWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class TelecomType(val value: String) {
    EXCHANGE("exchange"),               // A place to connect landlines subscribers to telecommunication service equipments
    CONNECTION_POINT("connection_point"), // Last point of telecom local loops allowing direct connections towards a few households and subscribers
    DISTRIBUTION_POINT("distribution_point"), // Equipment, often small boxes, allowing to directly connect up to 15 individuals or households to a single upstream local loop cable towards telecom exchanges
    SERVICE_DEVICE("service_device"),   // Active equipment which deliver service to connected customers. It can be for instance a DSLAM, a telephone switch, or more recently an OLT for optical networks. It excludes amplifiers or repeaters installed along local loops or long distance lines.
    DATA_CENTER("data_center"),         // A building used to house computers and network equipment.
    LINE("line"),                       // A telecommunication line.
    OTHER("other")
}
