			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class HighwayNode(
                val node: OsmNode,
                val type: HighwayType
            )

            data class HighwayWay(
                val way: OsmWay,
                val type: HighwayType
            )

            data class HighwayRel(
                val rel: OsmRel,
                val type: HighwayType
            )

            data class HighwayFeatures(
                val nodes: MutableList<HighwayNode> = mutableListOf(),
                val ways: MutableList<HighwayWay> = mutableListOf(),
                val rels: MutableList<HighwayRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["highway"]
                    val type = HighwayType.entries.firstOrNull { it.value == enumValue }
                        ?: HighwayType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(HighwayNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(HighwayRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(HighwayWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class HighwayType(val value: String) {
                MOTORWAY("motorway"),               // A restricted access major divided highway, normally with 2 or more running lanes plus emergency hard shoulder. Equivalent to the Freeway, Autobahn, etc..
				TRUNK("trunk"),                     // The most important roads in a country's system that aren't motorways. (Need not necessarily be a divided highway.)
				PRIMARY("primary"),                 // The next most important roads in a country's system. (Often link larger towns.)
				SECONDARY("secondary"),             // The next most important roads in a country's system. (Often link towns.)
				TERTIARY("tertiary"),               // The next most important roads in a country's system. (Often link smaller towns and villages)
				UNCLASSIFIED("unclassified"),       // The least important through roads in a country's system – i.e. minor roads of a lower classification than tertiary, but which serve a purpose other than access to properties. (Often link villages and hamlets.) The word 'unclassified' is a historical artefact of the UK road system and does not mean that the classification is unknown; you can use highway=road for that.
				RESIDENTIAL("residential"),         // Roads which serve as an access to housing, without function of connecting settlements. Often lined with housing.
				MOTORWAY_LINK("motorway_link"),     // The link roads (sliproads/ramps) leading to/from a motorway from/to a motorway or lower class highway. Normally with the same motorway restrictions.
				TRUNK_LINK("trunk_link"),           // The link roads (sliproads/ramps) leading to/from a trunk road from/to a trunk road or lower class highway.
				PRIMARY_LINK("primary_link"),       // The link roads (sliproads/ramps) leading to/from a primary road from/to a primary road or lower class highway.
				SECONDARY_LINK("secondary_link"),   // The link roads (sliproads/ramps) leading to/from a secondary road from/to a secondary road or lower class highway.
				TERTIARY_LINK("tertiary_link"),     // The link roads (sliproads/ramps) leading to/from a tertiary road from/to a tertiary road or lower class highway.
				LIVING_STREET("living_street"),     // For living streets, which are residential streets where pedestrians have legal priority over cars, speeds are kept very low and this is can use for narrow roads that usually using for motorcycle roads.
				SERVICE("service"),                 // For access roads to, or within an industrial estate, camp site, business park, car park, alleys, etc. Can be used in conjunction with service=* to indicate the type of usage and with access=* to indicate who can use it and in what circumstances.
				PEDESTRIAN("pedestrian"),           // For roads used mainly/exclusively for pedestrians in shopping and some residential areas which may allow access by motorised vehicles only for very limited periods of the day. To create a 'square' or 'plaza' create a closed way and tag as pedestrian and also with area=yes.
				TRACK("track"),                     // Roads for mostly agricultural or forestry uses. To describe the quality of a track, see tracktype=*. Note: Although tracks are often rough with unpaved surfaces, this tag is not describing the quality of a road but its use. Consequently, if you want to tag a general use road, use one of the general highway values instead of track.
				BUS_GUIDEWAY("bus_guideway"),       // A busway where the vehicle guided by the way (though not a railway) and is not suitable for other traffic. Please note: this is not a normal bus lane, use access=no, psv=yes instead!
				ESCAPE("escape"),                   // For runaway truck ramps, runaway truck lanes, emergency escape ramps, or truck arrester beds. It enables vehicles with braking failure to safely stop.
				RACEWAY("raceway"),                 // A course or track for (motor) racing
				ROAD("road"),                       // A road/way/street/motorway/etc. of unknown type. It can stand for anything ranging from a footpath to a motorway. This tag should only be used temporarily until the road/way/etc. has been properly surveyed. If you do know the road type, do not use this value, instead use one of the more specific highway=* values.
				BUSWAY("busway"),                   // A dedicated roadway for bus rapid transit systems
				FOOTWAY("footway"),                 // For designated footpaths; i.e., mainly/exclusively for pedestrians. This includes walking tracks and gravel paths. If bicycles are allowed as well, you can indicate this by adding a bicycle=yes tag. Should not be used for paths where the primary or intended usage is unknown. Use highway=pedestrian for pedestrianised roads in shopping or residential areas and highway=track if it is usable by agricultural or similar vehicles. For ramps (sloped paths without steps), combine this tag with incline=*.
				BRIDLEWAY("bridleway"),             // For horse riders. Pedestrians are usually also permitted, cyclists may be permitted depending on local rules/laws. Motor vehicles are forbidden.
				STEPS("steps"),                     // For flights of steps (stairs) on footways. Use with step_count=* to indicate the number of steps
				CORRIDOR("corridor"),               // For a hallway inside of a building.
				PATH("path"),                       // A non-specific path. Use highway=footway for paths mainly for walkers, highway=cycleway for one also usable by cyclists, highway=bridleway for ones available to horse riders as well as walkers and highway=track for ones which is passable by agriculture or similar vehicles.
				VIA_FERRATA("via_ferrata"),         // A via ferrata is a route equipped with fixed cables, stemples, ladders, and bridges in order to increase ease and security for climbers. These via ferrata require equipment : climbing harness, shock absorber and two short lengths of rope, but do not require a long rope as for climbing.
				CYCLEWAY("cycleway"),               // For designated cycleways. Add foot=*, though it may be avoided if default-access-restrictions do apply.
				PROPOSED("proposed"),               // For planned roads, use with proposed=* and a value of the proposed highway value.
				CONSTRUCTION("construction"),       // For roads under construction. Use construction=* to hold the value for the completed road.
				BUS_STOP("bus_stop"),               // A small bus stop. Optionally one may also use public_transport=stop_position for the position where the vehicle stops and public_transport=platform for the place where passengers wait.
				CROSSING("crossing"),               // A.k.a. crosswalk. Pedestrians can cross a street here; e.g., zebra crossing
				CYCLIST_WAITING_AID("cyclist_waiting_aid"), // Street furniture for cyclists that are intended to make waiting at esp. traffic lights more comfortable.
				ELEVATOR("elevator"),               // An elevator or lift, used to travel vertically, providing passenger and freight access between pathways at different floor levels.
				EMERGENCY_BAY("emergency_bay"),     // An area beside a highway where you can safely stop your car in case of breakdown or emergency.
				EMERGENCY_ACCESS_POINT("emergency_access_point"), // Sign number which can be used to define your current position in case of an emergency. Use with ref=NUMBER_ON_THE_SIGN. See also emergency=access_point
				GIVE_WAY("give_way"),               // A "give way," or "Yield" sign
				LADDER("ladder"),                   // A vertical or inclined set of steps or rungs intended for climbing or descending of a person with the help of hands.
				MILESTONE("milestone"),             // Highway location marker
				MINI_ROUNDABOUT("mini_roundabout"), // Similar to roundabouts, but at the center there is either a painted circle or a fully traversable island. In case of an untraversable center island, junction=roundabout should be used. Rendered as anti-clockwise by default direction=anticlockwise. To render clockwise add the tag direction=clockwise.
				MOTORWAY_JUNCTION("motorway_junction"), // Indicates a junction (UK) or exit (US). ref=* should be set to the exit number or junction identifier. (Some roads – e.g., the A14 – also carry junction numbers, so the tag may be encountered elsewhere despite its name)
				PASSING_PLACE("passing_place"),     // The location of a passing space
				PLATFORM("platform"),               // A platform at a bus stop or station.
				REST_AREA("rest_area"),             // Place where drivers can leave the road to rest, but not refuel.
				SERVICES("services"),               // A service station to get food and eat something, often found at motorways
				SPEED_CAMERA("speed_camera"),       // A fixed road-side or overhead speed camera.
				STOP("stop"),                       // A stop sign
				STREET_LAMP("street_lamp"),         // A street light, lamppost, street lamp, light standard, or lamp standard is a raised source of light on the edge of a road, which is turned on or lit at a certain time every night
				TOLL_GANTRY("toll_gantry"),         // A toll gantry is a gantry suspended over a way, usually a motorway, as part of a system of electronic toll collection. For a toll booth with any kind of barrier or booth see: barrier=toll_booth
				TRAFFIC_MIRROR("traffic_mirror"),   // Mirror that reflects the traffic on one road when direct view is blocked.
				TRAFFIC_SIGNALS("traffic_signals"), // Lights that control the traffic
				TRAILHEAD("trailhead"),             // Designated place to start on a trail or route
				TURNING_CIRCLE("turning_circle"),   // A turning circle is a rounded, widened area usually, but not necessarily, at the end of a road to facilitate easier turning of a vehicle. Also known as a cul de sac.
				TURNING_LOOP("turning_loop"),       // A widened area of a highway with a non-traversable island for turning around, often circular and at the end of a road.
                OTHER("other")
            }