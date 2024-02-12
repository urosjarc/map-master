			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class AerowayNode(
                val node: OsmNode,
                val type: AerowayType
            )

            data class AerowayWay(
                val way: OsmWay,
                val type: AerowayType
            )

            data class AerowayRel(
                val rel: OsmRel,
                val type: AerowayType
            )

            data class AerowayFeatures(
                val nodes: MutableList<AerowayNode> = mutableListOf(),
                val ways: MutableList<AerowayWay> = mutableListOf(),
                val rels: MutableList<AerowayRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["aeroway"]
                    val type = AerowayType.entries.firstOrNull { it.value == enumValue }
                        ?: AerowayType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(AerowayNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(AerowayRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(AerowayWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class AerowayType(val value: String) {
                AERODROME("aerodrome"),             // An aerodrome, airport or airfield
				AIRCRAFT_CROSSING("aircraft_crossing"), // A point where the flow of traffic is impacted by crossing aircraft.
				APRON("apron"),                     // An area of an airport where planes are parked, unloaded or loaded, refueled, or boarded
				GATE("gate"),                       // The bounded space, inside the airport terminal, where passengers wait before boarding their flight
				HANGAR("hangar"),                   // A large airport building with extensive floor areas for housing aircraft or spacecraft
				HELIPAD("helipad"),                 // A landing area or platform designed for helicopters
				HELIPORT("heliport"),               // A special aerodrome built for helicopters
				NAVIGATIONAID("navigationaid"),     // A facility that supports visual navigation for aircraft
				RUNWAY("runway"),                   // A strip of land on which aircraft can take off and land.
				SPACEPORT("spaceport"),             // A spaceport or cosmodrome: a site for launching or receiving spacecraft
				TAXIWAY("taxiway"),                 // A route where airplanes manouevre between runways and parking areas within an aerodrome
				TERMINAL("terminal"),               // An airport passenger building
				WINDSOCK("windsock"),               // An object that shows wind direction and speed.
                OTHER("other")
            }