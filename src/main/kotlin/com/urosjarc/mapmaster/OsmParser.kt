package com.urosjarc.mapmaster

//import com.urosjarc.mapmaster.domain.OsmMap
//import com.urosjarc.mapmaster.domain.OsmNode
//import com.urosjarc.mapmaster.domain.OsmRel
//import com.urosjarc.mapmaster.domain.OsmWay
//import java.nio.file.Path
//import kotlin.io.path.forEachLine
//
//object OsmParser {
//    val map: OsmMap? = null
//
//    private enum class State { NONE, NODE, WAY, RELATION }
//
//    data class Member(
//        val type: String,
//        val ref: Long,
//        val role: String
//    )
//
//    fun parse(path: Path): OsmMap {
//        //Parsing state
//        var state = State.NONE
//
//        //Map data
//        var map: OsmMap? = null
//
//        //Node data
//        var node: OsmNode? = null
//        val osmNodes = mutableMapOf<Long, OsmNode>() //Id to node
//
//        //Way data
//        var way: OsmWay? = null
//        val osmWays = mutableMapOf<Long, OsmWay>() //Id to way
//        val osmWaysRefs = mutableMapOf<Long, MutableList<Long>>() //Id to node id
//
//        //Rel data
//        var rel: OsmRel? = null
//        val osmRels = mutableMapOf<Long, OsmRel>() //Id to rel
//        val osmRelsMembers = mutableMapOf<Long, MutableList<Member>>() //Id to members
//
//        //Parsing each line one by one
//        path.forEachLine {
//            val line = it.trim()
//            val attrs = parseLine(line)
//
//            if (line.startsWith("<?xml")) {
//                state = State.NONE
//            } else if (line.startsWith("<osm")) {
//                state = State.NONE
//            } else if (line.startsWith("<bounds")) {
//                map = OsmMap(
//                    minLat = attrs["minlat"]!!.toFloat(),
//                    maxLat = attrs["maxlat"]!!.toFloat(),
//                    minLon = attrs["minlon"]!!.toFloat(),
//                    maxLon = attrs["maxlon"]!!.toFloat()
//                )
//            } else if (line.startsWith("<node")) {
//                state = State.NODE
//                node = OsmNode(
//                    id = attrs["id"]!!.toLong(),
//                    lat = attrs["lat"]!!.toFloat(),
//                    lon = attrs["lon"]!!.toFloat(),
//                )
//                osmNodes[node!!.id] = node!!
//            } else if (line.startsWith("<way")) {
//                state = State.WAY
//                way = OsmWay(id = attrs["id"]!!.toLong())
//                osmWays[way!!.id] = way!!
//                osmWaysRefs[way!!.id] = mutableListOf()
//            } else if (line.startsWith("<relation")) {
//                state = State.RELATION
//                rel = OsmRel(id = attrs["id"]!!.toLong())
//                osmRels[rel!!.id] = rel!!
//                osmRelsMembers[rel!!.id] = mutableListOf()
//            } else if (line.startsWith("<tag")) {
//                val key = attrs["k"]!!
//                val value = attrs["v"]!!
//                when (state) {
//                    State.NONE -> throw Exception(it)
//                    State.NODE -> node!!.tags[key] = value
//                    State.WAY -> way!!.tags[key] = value
//                    State.RELATION -> rel!!.tags[key] = value
//                }
//            } else if (line.startsWith("<nd")) {
//                when (state) {
//                    State.NONE -> throw Exception(it)
//                    State.NODE -> throw Exception(it)
//                    State.WAY -> osmWaysRefs[way!!.id]!!.add(attrs["ref"]!!.toLong())
//                    State.RELATION -> throw Exception(it)
//                }
//            } else if (line.startsWith("<member")) {
//                val member = Member(
//                    type = attrs["type"]!!,
//                    ref = attrs["ref"]!!.toLong(),
//                    role = attrs["role"]!!,
//                )
//                when (state) {
//                    State.NONE -> throw Exception(it)
//                    State.NODE -> throw Exception(it)
//                    State.WAY -> throw Exception(it)
//                    State.RELATION -> osmRelsMembers[rel!!.id]!!.add(member)
//                }
//            } else if (line.startsWith("</way>")) {
//                state = State.NONE
//            } else if (line.startsWith("</relation>")) {
//                state = State.NONE
//            } else if (line.startsWith("</node>")) {
//                state = State.NONE
//            } else if (line.startsWith("</osm>")) {
//                state = State.NONE
//            } else throw Exception(it)
//        }
//
//        //Connecting data
//        var count = 0
//        osmWaysRefs.forEach { wayId, nodesIds ->
//            val way = osmWays[wayId]!!
//            nodesIds.forEach { nodeId ->
//                val node = osmNodes[nodeId]!!
//                way.nodes.add(node)
//                count ++
//            }
//            map!!.addMapFeature(feature = way)
//        }
//        println("Ways: ${osmWays.size}")
//        println("Nodes: ${osmNodes.size}")
//        println("Connections: $count")
//        return map!!
//    }
//
//    fun parseLine(line: String): Map<String, String> {
//        return line
//            .replace("/>", "")
//            .replace(">", "")
//            .split(" ")
//            .filter { it.contains("=") }
//            .map {
//                it.replace("\"", "").split("=")
//            }.map { it.first() to it.last() }.toMap()
//    }
//}
