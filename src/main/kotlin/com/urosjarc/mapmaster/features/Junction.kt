			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class JunctionNode(
                val node: OsmNode,
                val type: JunctionType
            )

            data class JunctionWay(
                val way: OsmWay,
                val type: JunctionType
            )

            data class JunctionRel(
                val rel: OsmRel,
                val type: JunctionType
            )

            data class JunctionFeatures(
                val nodes: MutableList<JunctionNode> = mutableListOf(),
                val ways: MutableList<JunctionWay> = mutableListOf(),
                val rels: MutableList<JunctionRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["junction"]
                    val type = JunctionType.entries.firstOrNull { it.value == enumValue }
                        ?: JunctionType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(JunctionNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(JunctionRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(JunctionWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class JunctionType(val value: String) {
                ROUNDABOUT("roundabout"),           // This automatically implies oneway=yes, the oneway direction is defined by the sequential ordering of nodes within the Way. This applies on a way, tagged with highway=* already.
                OTHER("other")
            }