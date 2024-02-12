			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class TrafficSignNode(
                val node: OsmNode,
                val type: TrafficSignType
            )

            data class TrafficSignWay(
                val way: OsmWay,
                val type: TrafficSignType
            )

            data class TrafficSignRel(
                val rel: OsmRel,
                val type: TrafficSignType
            )

            data class TrafficSignFeatures(
                val nodes: MutableList<TrafficSignNode> = mutableListOf(),
                val ways: MutableList<TrafficSignWay> = mutableListOf(),
                val rels: MutableList<TrafficSignRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["traffic_sign"]
                    val type = TrafficSignType.entries.firstOrNull { it.value == enumValue }
                        ?: TrafficSignType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(TrafficSignNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(TrafficSignRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(TrafficSignWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class TrafficSignType(val value: String) {
                CITY_LIMIT("city_limit"),           // Start/end sign of city limits, in most countries implies a specific "city maxspeed".
                OTHER("other")
            }