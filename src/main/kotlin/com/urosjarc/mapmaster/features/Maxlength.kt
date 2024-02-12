			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class MaxlengthNode(
                val node: OsmNode,
                val type: MaxlengthType
            )

            data class MaxlengthWay(
                val way: OsmWay,
                val type: MaxlengthType
            )

            data class MaxlengthRel(
                val rel: OsmRel,
                val type: MaxlengthType
            )

            data class MaxlengthFeatures(
                val nodes: MutableList<MaxlengthNode> = mutableListOf(),
                val ways: MutableList<MaxlengthWay> = mutableListOf(),
                val rels: MutableList<MaxlengthRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["maxlength"]
                    val type = MaxlengthType.entries.firstOrNull { it.value == enumValue }
                        ?: MaxlengthType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(MaxlengthNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(MaxlengthRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(MaxlengthWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class MaxlengthType(val value: String) {
                LENGTH("Length"),                   // Length limit – units other than metres should be explicit
                OTHER("other")
            }