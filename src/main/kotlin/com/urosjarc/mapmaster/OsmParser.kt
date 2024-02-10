package com.urosjarc.mapmaster

import java.nio.file.Path
import kotlin.io.path.forEachLine

object OsmParser {
    val map: OsmMap? = null

    private enum class State { NONE, NODE, WAY, RELATION }

    data class Member(
        val ref: Long,
        val role: String,
        val type: OsmFeature.Type,
    )

    fun parse(path: Path): OsmMap {
        //Parsing state
        var state = State.NONE

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

        //Parsing each line one by one
        path.forEachLine {
            val line = it.trimStart()

            if (line.startsWith("<?xml")) {
                state = State.NONE
            } else if (line.startsWith("<osm")) {
                state = State.NONE
            } else if (line.startsWith("<bounds")) {
                val attrs = parseLine(line)
                map = OsmMap(
                    minLat = attrs["minlat"]!!.toFloat(),
                    maxLat = attrs["maxlat"]!!.toFloat(),
                    minLon = attrs["minlon"]!!.toFloat(),
                    maxLon = attrs["maxlon"]!!.toFloat()
                )
            } else if (line.startsWith("<node")) {
                state = State.NODE
                val attrs = parseLine(line)
                curOsmNode = OsmNode(
                    id = attrs["id"]!!.toLong(),
                    lat = attrs["lat"]!!.toFloat(),
                    lon = attrs["lon"]!!.toFloat(),
                )
                osmNodes[curOsmNode!!.id] = curOsmNode!!
            } else if (line.startsWith("<way")) {
                state = State.WAY
                val attrs = parseLine(line)
                curOsmWay = OsmWay(id = attrs["id"]!!.toLong())
                osmWays[curOsmWay!!.id] = curOsmWay!!
                osmWaysRefs[curOsmWay!!.id] = mutableListOf()
            } else if (line.startsWith("<relation")) {
                state = State.RELATION
                val attrs = parseLine(line)
                curOsmRel = OsmRel(id = attrs["id"]!!.toLong())
                osmRels[curOsmRel!!.id] = curOsmRel!!
                osmRelsMembers[curOsmRel!!.id] = mutableListOf()
            } else if (line.startsWith("<tag")) {
                val attrs = parseLine(line)
                val key = attrs["k"]!!
                val value = attrs["v"]!!
                when (state) {
                    State.NONE -> throw Exception(it)
                    State.NODE -> curOsmNode!!.tags[key] = value
                    State.WAY -> curOsmWay!!.tags[key] = value
                    State.RELATION -> curOsmRel!!.tags[key] = value
                }
            } else if (line.startsWith("<nd")) {
                val attrs = parseLine(line)
                when (state) {
                    State.NONE -> throw Exception(it)
                    State.NODE -> throw Exception(it)
                    State.WAY -> osmWaysRefs[curOsmWay!!.id]!!.add(attrs["ref"]!!.toLong())
                    State.RELATION -> throw Exception(it)
                }
            } else if (line.startsWith("<member")) {
                val attrs = parseLine(line)
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

        //Connecting nodes
        osmNodes.forEach { _, node ->
            map!!.features.add(feature = OsmFeature(obj = node, objType = OsmFeature.Type.NODE))
        }

        //Connecting ways
        osmWaysRefs.forEach { wayId, nodesIds ->
            val way = osmWays[wayId]!!
            nodesIds.forEach { nodeId -> way.nodes.add(osmNodes[nodeId]!!) }
            map!!.features.add(feature = OsmFeature(obj = way, objType = OsmFeature.Type.WAY))
        }

        //Connecting relations
        osmRels.forEach { relId, rel ->
            osmRelsMembers[relId]!!.forEach {
                val role = if (it.role.isBlank()) null else it.role
                when (it.type) {
                    OsmFeature.Type.NODE -> osmNodes[it.ref]?.let { rel.nodes.add(OsmMember(obj = it, role = role)) }
                    OsmFeature.Type.WAY -> osmWays[it.ref]?.let { rel.ways.add(OsmMember(obj = it, role = role)) }
                    OsmFeature.Type.RELATIONSHIP -> osmRels[it.ref]?.let { rel.rels.add(OsmMember(obj = it, role = role)) }
                }
            }
            map!!.features.add(feature = OsmFeature(obj = rel, objType = OsmFeature.Type.RELATIONSHIP))
        }

        return map!!
    }

    fun parseLine(line: String): Map<String, String> {
        val matrix = line
            .split(" ", limit = 2)
            .last()
            .split("\" ")
            .map {
                val (key, value) = it.split("=\"", limit = 2)
                key to value
            }.toMutableList()

        val lastPair = matrix[matrix.size-1]
        matrix[matrix.size-1] = (lastPair.first to lastPair.second.split("\"").first())
        return matrix.toMap()
    }
}
