package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.domain.*
import kotlin.io.path.Path
import kotlin.io.path.forEachLine

object OsmParser {
    private enum class State { NONE, NODE, WAY, RELATION }

    private data class Member(
        val ref: Long,
        val role: String,
        val type: OsmFeature.Type,
    )

    fun parseAttributes(xml: String): Map<String, String> {
        val matrix = xml
            .split(" ", limit = 2)
            .last()
            .split("\" ")
            .map {
                val (key, value) = it.split("=\"", limit = 2)
                key to value
            }.toMutableList()

        val lastPair = matrix[matrix.size - 1]
        matrix[matrix.size - 1] = (lastPair.first to lastPair.second.split("\"").first())
        return matrix.toMap()
    }

    fun parse(path: String, srtmMaps: List<SrtmMap> = listOf()): OsmMap {
        //Srtm maps
        val position_to_srtmMap = srtmMaps.associateBy { it.lat to it.lon }

        //Map data
        var map: OsmMap? = null

        //Node data
        var curOsmNode: OsmNode? = null
        val osmNodes = mutableMapOf<Long, OsmNode>() //Id to node

        //Way data
        var curOsmWay: OsmWay? = null
        val osmWays = mutableMapOf<Long, OsmWay>() //Id to way
        val osmWaysRefs = mutableMapOf<Long, MutableList<Long>>() //Id to node id

        //Rel data
        var curOsmRel: OsmRel? = null
        val osmRels = mutableMapOf<Long, OsmRel>() //Id to rel
        val osmRelsMembers = mutableMapOf<Long, MutableList<Member>>() //Id to members

        //Current state of parsing
        var state = State.NONE

        //Now parse line by line
        Path(path).forEachLine {
            val line = it.trimStart()

            if (line.startsWith("<?xml")) {
                state = State.NONE
            } else if (line.startsWith("<osm")) {
                state = State.NONE
            } else if (line.startsWith("<bounds")) {
                val attrs = parseAttributes(line)
                map = OsmMap(
                    minLat = attrs["minlat"]!!.toDouble(),
                    maxLat = attrs["maxlat"]!!.toDouble(),
                    minLon = attrs["minlon"]!!.toDouble(),
                    maxLon = attrs["maxlon"]!!.toDouble()
                )
            } else if (line.startsWith("<node")) {
                state = State.NODE
                val attrs = parseAttributes(line)
                val pos = MapPosition(
                    lat = attrs["lat"]!!.toDouble(),
                    lon = attrs["lon"]!!.toDouble(),
                )
                val elevation = position_to_srtmMap[pos.lat.toInt() to pos.lon.toInt()]?.elevation(pos)
                curOsmNode = OsmNode(
                    id = attrs["id"]!!.toLong(),
                    elevation = elevation,
                    position = pos
                )
                osmNodes[curOsmNode!!.id] = curOsmNode!!
            } else if (line.startsWith("<way")) {
                state = State.WAY
                val attrs = parseAttributes(line)
                curOsmWay = OsmWay(id = attrs["id"]!!.toLong())
                osmWays[curOsmWay!!.id] = curOsmWay!!
                osmWaysRefs[curOsmWay!!.id] = mutableListOf()
            } else if (line.startsWith("<relation")) {
                state = State.RELATION
                val attrs = parseAttributes(line)
                curOsmRel = OsmRel(id = attrs["id"]!!.toLong())
                osmRels[curOsmRel!!.id] = curOsmRel!!
                osmRelsMembers[curOsmRel!!.id] = mutableListOf()
            } else if (line.startsWith("<tag")) {
                val attrs = parseAttributes(line)
                val key = attrs["k"]!!
                val value = attrs["v"]!!
                when (state) {
                    State.NONE -> throw Exception(it)
                    State.NODE -> curOsmNode!!.tags[key] = value
                    State.WAY -> curOsmWay!!.tags[key] = value
                    State.RELATION -> curOsmRel!!.tags[key] = value
                }
            } else if (line.startsWith("<nd")) {
                val attrs = parseAttributes(line)
                when (state) {
                    State.NONE -> throw Exception(it)
                    State.NODE -> throw Exception(it)
                    State.WAY -> osmWaysRefs[curOsmWay!!.id]!!.add(attrs["ref"]!!.toLong())
                    State.RELATION -> throw Exception(it)
                }
            } else if (line.startsWith("<member")) {
                val attrs = parseAttributes(line)
                val member = Member(
                    ref = attrs["ref"]!!.toLong(),
                    role = attrs["role"]!!,
                    type = when (attrs["type"]) {
                        "node" -> OsmFeature.Type.NODE
                        "way" -> OsmFeature.Type.WAY
                        "relation" -> OsmFeature.Type.RELATIONSHIP
                        else -> throw Exception(it)
                    }
                )
                osmRelsMembers[curOsmRel!!.id]!!.add(member)

            } else if (line.startsWith("</way>")) {
                state = State.NONE
            } else if (line.startsWith("</relation>")) {
                state = State.NONE
            } else if (line.startsWith("</node>")) {
                state = State.NONE
            } else if (line.startsWith("</osm>")) {
                state = State.NONE
            } else throw Exception(it)
        }

        //Adding node features
        osmNodes.forEach { _, node ->
            map!!.features.add(feature = OsmFeature(obj = node, objType = OsmFeature.Type.NODE))
        }

        //Connecting ways
        osmWaysRefs.forEach { wayId, nodesIds ->
            val way = osmWays[wayId]!!
            nodesIds.forEach { nodeId -> way.connect(node = osmNodes[nodeId]!!) }
            map!!.features.add(feature = OsmFeature(obj = way, objType = OsmFeature.Type.WAY))
        }

        //Connecting relations
        osmRels.forEach { relId, rel ->
            osmRelsMembers[relId]!!.forEach { member ->
                val role = if (member.role.isBlank()) null else member.role
                when (member.type) {
                    OsmFeature.Type.NODE ->
                        osmNodes[member.ref]?.let { rel.nodes.add(OsmMember(obj = it, role = role, objType = OsmFeature.Type.NODE)) }

                    OsmFeature.Type.WAY ->
                        osmWays[member.ref]?.let { rel.ways.add(OsmMember(obj = it, role = role, objType = OsmFeature.Type.WAY)) }

                    OsmFeature.Type.RELATIONSHIP ->
                        osmRels[member.ref]?.let { rel.rels.add(OsmMember(obj = it, role = role, objType = OsmFeature.Type.RELATIONSHIP)) }
                }
            }
            map!!.features.add(feature = OsmFeature(obj = rel, objType = OsmFeature.Type.RELATIONSHIP))
        }

        return map!!
    }
}
