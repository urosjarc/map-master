			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class HazardNode(
                val node: OsmNode,
                val type: HazardType
            )

            data class HazardWay(
                val way: OsmWay,
                val type: HazardType
            )

            data class HazardRel(
                val rel: OsmRel,
                val type: HazardType
            )

            data class HazardFeatures(
                val nodes: MutableList<HazardNode> = mutableListOf(),
                val ways: MutableList<HazardWay> = mutableListOf(),
                val rels: MutableList<HazardRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["hazard"]
                    val type = HazardType.entries.firstOrNull { it.value == enumValue }
                        ?: HazardType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(HazardNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(HazardRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(HazardWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class HazardType(val value: String) {
                HAZARD("hazard"),                   // Indicates of the hazards.
                OTHER("other")
            }