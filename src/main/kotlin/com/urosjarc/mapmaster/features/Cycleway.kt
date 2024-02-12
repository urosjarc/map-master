			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class CyclewayNode(
                val node: OsmNode,
                val type: CyclewayType
            )

            data class CyclewayWay(
                val way: OsmWay,
                val type: CyclewayType
            )

            data class CyclewayRel(
                val rel: OsmRel,
                val type: CyclewayType
            )

            data class CyclewayFeatures(
                val nodes: MutableList<CyclewayNode> = mutableListOf(),
                val ways: MutableList<CyclewayWay> = mutableListOf(),
                val rels: MutableList<CyclewayRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["cycleway"]
                    val type = CyclewayType.entries.firstOrNull { it.value == enumValue }
                        ?: CyclewayType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(CyclewayNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(CyclewayRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(CyclewayWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class CyclewayType(val value: String) {
                LANE("lane"),                       // A lane is a route that lies within the roadway
				OPPOSITE("opposite"),               // Used on ways with oneway=yes where it is legally permitted to cycle in both directions. Used together with oneway:bicycle=no.
				OPPOSITE_LANE("opposite_lane"),     // Used on ways with oneway=yes that have a cycling lane going the opposite direction of normal traffic flow (a "contraflow" lane). Used together with oneway:bicycle=no.
				TRACK("track"),                     // A track provides a route that is separated from traffic. In the United States, this term is often used to refer to bike lanes that are separated from lanes for cars by pavement buffers, bollards, parking lanes, and curbs. Note that a cycle track may alternatively be drawn as a separate way next to the road which is tagged as highway=cycleway.
				OPPOSITE_TRACK("opposite_track"),   // Used on ways with oneway=yes that have a cycling track going the opposite direction of normal traffic flow. Used together with oneway:bicycle=no.
				SHARE_BUSWAY("share_busway"),       // There is a bus lane that cyclists are permitted to use.
				OPPOSITE_SHARE_BUSWAY("opposite_share_busway"), // Used on ways with oneway=yes that have a bus lane that cyclists are also permitted to use, and which go in the opposite direction to normal traffic flow (a "contraflow" bus lane). Used together with oneway:bicycle=no.
				SHARED_LANE("shared_lane"),         // Cyclists share a lane with motor vehicles, but there are markings indicating that they should share the lane with motorists. In some places these markings are known as "sharrows" ('sharing arrows') and this is the tag to use for those.
                OTHER("other")
            }