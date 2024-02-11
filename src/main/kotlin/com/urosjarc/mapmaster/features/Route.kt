package com.urosjarc.mapmaster.features

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode
import com.urosjarc.mapmaster.domain.OsmRel
import com.urosjarc.mapmaster.domain.OsmWay

/**
 * This file is auto generated!
 */

data class RouteNode(
    val node: OsmNode,
    val type: RouteType
)

data class RouteWay(
    val way: OsmWay,
    val type: RouteType
)

data class RouteRel(
    val rel: OsmRel,
    val type: RouteType
)

data class RouteFeatures(
    val nodes: MutableList<RouteNode> = mutableListOf(),
    val ways: MutableList<RouteWay> = mutableListOf(),
    val rels: MutableList<RouteRel> = mutableListOf()
) {
    fun add(feature: OsmFeature) {
        val enumValue = feature.obj.tags["route"]
        val type = RouteType.entries.firstOrNull { it.value == enumValue }
            ?: RouteType.OTHER
        when (feature.objType) {

            OsmFeature.Type.NODE ->
                this.nodes.add(RouteNode(node = feature.obj as OsmNode, type = type))

            OsmFeature.Type.RELATIONSHIP ->
                this.rels.add(RouteRel(rel = feature.obj as OsmRel, type = type))

            OsmFeature.Type.WAY ->
                this.ways.add(RouteWay(way = feature.obj as OsmWay, type = type))

        }
    }
}

enum class RouteType(val value: String) {
    BICYCLE("bicycle"),                 // Cycle routes or bicycles route are named, numbered or otherwise signed. May go along roads, trails or dedicated cycle paths
    BUS("bus"),                         // The route a public bus service takes. See Buses.
    CANOE("canoe"),                     // Signed route for canoeing through a waterway.
    DETOUR("detour"),                   // Route for fixed detour routes. Examples are Bedarfsumleitung in Germany and uitwijkroute in the Netherlands
    FERRY("ferry"),                     // The route a ferry takes from terminal to terminal Please make sure to add at least one node per tile (zoom level 12), better at least one every few km, so offline editors catch it with bbox requests.
    FOOT("foot"),                       // Walking Route - is used for routes which are walkable without any limitations regarding fitness, equipment or weather conditions.
    HIKING("hiking"),                   // Hiking explains how to tag hiking routes.
    HORSE("horse"),                     // Riding routes
    INLINE_SKATES("inline_skates"),     // Inline has more information on the subject.
    LIGHT_RAIL("light_rail"),           // Route of a light rail line.
    MTB("mtb"),                         // Mountain biking explains how to tag mtb routes.
    PISTE("piste"),                     // Route of a piste (e.g., snowshoe or XC-Ski trails) in a winter sport area.
    RAILWAY("railway"),                 // A sequence of railway ways, often named (e.g., Channel Tunnel). See Railways.
    ROAD("road"),                       // Can be used to map various road routes/long roads.
    RUNNING("running"),                 // For running (jogging) routes.
    SKI("ski"),                         // For ski tracks (e.g., XC-Ski Trails User:Langläufer/Loipemap).
    SUBWAY("subway"),                   // Route of a metro service
    TRAIN("train"),                     // Train services (e.g., London-Paris Eurostar) See Railways.
    TRACKS("tracks"),                   // Railroad track as rail infrastructure.
    TRAM("tram"),                       // See Trams for more information on tagging tram services.
    TROLLEYBUS("trolleybus"),           // The route of a trolleybus service.
    OTHER("other")
}
