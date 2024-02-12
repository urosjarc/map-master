			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class MaxweightNode(
                val node: OsmNode,
                val type: MaxweightType
            )

            data class MaxweightWay(
                val way: OsmWay,
                val type: MaxweightType
            )

            data class MaxweightRel(
                val rel: OsmRel,
                val type: MaxweightType
            )

            data class MaxweightFeatures(
                val nodes: MutableList<MaxweightNode> = mutableListOf(),
                val ways: MutableList<MaxweightWay> = mutableListOf(),
                val rels: MutableList<MaxweightRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["maxweight"]
                    val type = MaxweightType.entries.firstOrNull { it.value == enumValue }
                        ?: MaxweightType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(MaxweightNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(MaxweightRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(MaxweightWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class MaxweightType(val value: String) {
                WEIGHT("Weight"),                   // Weight limit – units other than tonnes should be explicit
                OTHER("other")
            }