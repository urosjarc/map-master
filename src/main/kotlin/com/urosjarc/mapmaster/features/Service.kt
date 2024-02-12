			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class ServiceNode(
                val node: OsmNode,
                val type: ServiceType
            )

            data class ServiceWay(
                val way: OsmWay,
                val type: ServiceType
            )

            data class ServiceRel(
                val rel: OsmRel,
                val type: ServiceType
            )

            data class ServiceFeatures(
                val nodes: MutableList<ServiceNode> = mutableListOf(),
                val ways: MutableList<ServiceWay> = mutableListOf(),
                val rels: MutableList<ServiceRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["service"]
                    val type = ServiceType.entries.firstOrNull { it.value == enumValue }
                        ?: ServiceType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(ServiceNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(ServiceRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(ServiceWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class ServiceType(val value: String) {
                ALLEY("alley"),                     // See Key:service for more details.
				CROSSOVER("crossover"),             // Relatively short lengths of track which switch traffic from one parallel line to another
				SIDING("siding"),                   // Relatively short lengths of track, running parallel to (and connected to) a main route
				SPUR("spur"),                       // Relatively short lengths of track, built to give one company or entity access to a main or branch line.
				YARD("yard"),                       // Tracks within railway company operated marshalling or maintenance yards.
                OTHER("other")
            }