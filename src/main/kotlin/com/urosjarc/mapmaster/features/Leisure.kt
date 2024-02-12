			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class LeisureNode(
                val node: OsmNode,
                val type: LeisureType
            )

            data class LeisureWay(
                val way: OsmWay,
                val type: LeisureType
            )

            data class LeisureRel(
                val rel: OsmRel,
                val type: LeisureType
            )

            data class LeisureFeatures(
                val nodes: MutableList<LeisureNode> = mutableListOf(),
                val ways: MutableList<LeisureWay> = mutableListOf(),
                val rels: MutableList<LeisureRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["leisure"]
                    val type = LeisureType.entries.firstOrNull { it.value == enumValue }
                        ?: LeisureType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(LeisureNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(LeisureRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(LeisureWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class LeisureType(val value: String) {
                ADULT_GAMING_CENTRE("adult_gaming_centre"), // A venue with gambling machines, usually with a minimum age requirement
				AMUSEMENT_ARCADE("amusement_arcade"), // A venue with pay-to-play games.
				BEACH_RESORT("beach_resort"),       // A managed beach, including within the boundary any associated facilities. Entry may also require payment of a fee.
				BANDSTAND("bandstand"),             // A bandstand is an open structure where musical bands can perform concerts
				BIRD_HIDE("bird_hide"),             // A place that is used to observe wildlife, especially birds.
				COMMON("common"),                   // Identify land over which the public has general rights of use for certain leisure activities.
				DANCE("dance"),                     // A dance venue or dance hall.
				DISC_GOLF_COURSE("disc_golf_course"), // A place to play disc golf
				DOG_PARK("dog_park"),               // A designated area, with or without a fenced boundary, where dog-owners are permitted to exercise their pets unrestrained.
				ESCAPE_GAME("escape_game"),         // A physical adventure game in which players solve a series of puzzles using clues, hints and strategy to complete the objectives at hand.
				FIREPIT("firepit"),                 // A fire ring or fire pit, often at a campsite or picnic site
				FISHING("fishing"),                 // A public or private place for fishing
				FITNESS_CENTRE("fitness_centre"),   // Fitness centre, health club or gym with exercise machines, fitness classes or both, for exercise.
				FITNESS_STATION("fitness_station"), // An outdoor facility where people can practise typical fitness exercises
				GARDEN("garden"),                   // A place where flowers and other plants are grown in a decorative and structured manner or for scientific purposes.
				HACKERSPACE("hackerspace"),         // A place where people with common interests (science, technology, ...) meet.
				HORSE_RIDING("horse_riding"),       // A facility where people practise horse riding, usually in their spare time, e.g. a riding centre. For a riding arena use tag:leisure=pitch + tag:sport=equestrian.
				ICE_RINK("ice_rink"),               // A place where you can skate and play bandy or ice hockey.
				MARINA("marina"),                   // A facility for mooring leisure yachts and motor boats.
				MINIATURE_GOLF("miniature_golf"),   // A place or area where you can play miniature golf.
				NATURE_RESERVE("nature_reserve"),   // A protected area of importance for wildlife, flora, fauna or features of geological or other special interest.
				PARK("park"),                       // A park, usually in an urban (municipal) setting, created for recreation and relaxation.
				PICNIC_TABLE("picnic_table"),       // A table with benches for food and rest
				PITCH("pitch"),                     // An area designed for practising a particular sport, normally designated with appropriate markings.
				PLAYGROUND("playground"),           // A playground: an area designed for children to play.
				SLIPWAY("slipway"),                 // A slipway: a ramp for launching a boat into water
				SPORTS_CENTRE("sports_centre"),     // A sports centre is a distinct facility where sports take place within an enclosed area.
				STADIUM("stadium"),                 // A major sports facility with substantial tiered seating.
				SUMMER_CAMP("summer_camp"),         // A place for supervised camps for children or teenagers conducted during the summer months
				SWIMMING_AREA("swimming_area"),     // An area for swimming within a larger body of water (such as a river, lake or the sea) that is marked by a rope, buoys or similar
				SWIMMING_POOL("swimming_pool"),     // A swimming pool (water area only)
				TRACK("track"),                     // A track for running, cycling and other non-motorised racing such as horses, greyhounds.
				WATER_PARK("water_park"),           // An amusement park with features like water slides, recreational pools (e.g. wave pools) or lazy rivers.
                OTHER("other")
            }