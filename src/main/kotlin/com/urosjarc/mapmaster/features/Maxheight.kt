			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class MaxheightNode(
                val node: OsmNode,
                val type: MaxheightType
            )

            data class MaxheightWay(
                val way: OsmWay,
                val type: MaxheightType
            )

            data class MaxheightRel(
                val rel: OsmRel,
                val type: MaxheightType
            )

            data class MaxheightFeatures(
                val nodes: MutableList<MaxheightNode> = mutableListOf(),
                val ways: MutableList<MaxheightWay> = mutableListOf(),
                val rels: MutableList<MaxheightRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["maxheight"]
                    val type = MaxheightType.entries.firstOrNull { it.value == enumValue }
                        ?: MaxheightType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(MaxheightNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(MaxheightRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(MaxheightWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class MaxheightType(val value: String) {
                HEIGHT("Height"),                   // Height limit – units other than metres should be explicit
                OTHER("other")
            }