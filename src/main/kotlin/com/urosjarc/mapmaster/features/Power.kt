			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class PowerNode(
                val node: OsmNode,
                val type: PowerType
            )

            data class PowerWay(
                val way: OsmWay,
                val type: PowerType
            )

            data class PowerRel(
                val rel: OsmRel,
                val type: PowerType
            )

            data class PowerFeatures(
                val nodes: MutableList<PowerNode> = mutableListOf(),
                val ways: MutableList<PowerWay> = mutableListOf(),
                val rels: MutableList<PowerRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["power"]
                    val type = PowerType.entries.firstOrNull { it.value == enumValue }
                        ?: PowerType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(PowerNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(PowerRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(PowerWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class PowerType(val value: String) {
                CABLE("cable"),                     // An insulated cable carrying electrical power, such as transmission or distribution cables located underground and undersea cables
				CATENARY_MAST("catenary_mast"),     // A pole supporting the overhead wires used to supply electricity to vehicles equipped with a pantograph such as trams and trains
				COMPENSATOR("compensator"),         // A static power device used to ensure power quality and electrical network resilience.
				CONNECTION("connection"),           // A free-standing electrical connection between two or more overhead wires
				CONVERTER("converter"),             // A device to convert power between alternating and direct current electrical power: often, but not only, over high voltage networks
				GENERATOR("generator"),             // A device which converts one form of energy to another, for example, an electrical generator.
				HELIOSTAT("heliostat"),             // A mirror of a heliostat device
				INSULATOR("insulator"),             // An electrical insulator which connects a power line to a support structure and prevents grounding.
				LINE("line"),                       // High-voltage power lines used for power transmission, usually supported by towers or pylons
				MINOR_LINE("minor_line"),           // Minor power lines forming the distribution grid, usually carried by poles.
				PLANT("plant"),                     // An industrial facility where power (electricity, useful heat, biogas) is produced by individual power generator units.
				POLE("pole"),                       // A single pole supporting power lines, often a wood, steel, or concrete mast designed to carry minor power lines.
				PORTAL("portal"),                   // A supporting structure for power lines, composed of vertical legs with cables between them attached to a horizontal crossarm.
				SUBSTATION("substation"),           // A facility which controls the flow of electricity in a power network with transformers, switchgear or compensators.
				SWITCH("switch"),                   // A device which allows electrical network operators to power up & down lines and transformers in substations or along the power grid.
				SWITCHGEAR("switchgear"),           // A switchgear, which comprises one or more busbar assemblies and a number of bays each connecting a circuit to the busbar assembly.
				TERMINAL("terminal"),               // A point of connection where an overhead power line ends on a building or wall; for example, when connecting it to an indoor substation.
				TOWER("tower"),                     // A tower or pylon carrying high voltage electricity cables. Often constructed from steel latticework but tubular or solid pylons are also used.
				TRANSFORMER("transformer"),         // A device for stepping up or down electric voltage. Large power transformers are typically located inside substations
                OTHER("other")
            }