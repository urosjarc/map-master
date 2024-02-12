			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class NaturalNode(
                val node: OsmNode,
                val type: NaturalType
            )

            data class NaturalWay(
                val way: OsmWay,
                val type: NaturalType
            )

            data class NaturalRel(
                val rel: OsmRel,
                val type: NaturalType
            )

            data class NaturalFeatures(
                val nodes: MutableList<NaturalNode> = mutableListOf(),
                val ways: MutableList<NaturalWay> = mutableListOf(),
                val rels: MutableList<NaturalRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["natural"]
                    val type = NaturalType.entries.firstOrNull { it.value == enumValue }
                        ?: NaturalType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(NaturalNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(NaturalRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(NaturalWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class NaturalType(val value: String) {
                FELL("fell"),                       // Habitat above tree line covered with grass, dwarf shrubs and mosses.
				GRASSLAND("grassland"),             // Areas where the vegetation is dominated by grasses (Poaceae) and other herbaceous (non-woody) plants.
				HEATH("heath"),                     // A dwarf-shrub habitat, characterised by open, low growing woody vegetation, often dominated by plants of the Ericaceae.
				MOOR("moor"),                       // Don't use, see wikipage
				SCRUB("scrub"),                     // Uncultivated land covered with shrubs, bushes or stunted trees.
				SHRUBBERY("shrubbery"),             // An area of woody shrubbery that is actively maintained or pruned by humans. A slightly wilder look is also possible.
				TREE("tree"),                       // A single tree
				TREE_ROW("tree_row"),               // A line of trees
				TUNDRA("tundra"),                   // Treeless cold climate habitat with open, low growing sedges, grasses, mosses and lichens.
				WOOD("wood"),                       // Tree-covered area (a 'forest' or 'wood')
				BAY("bay"),                         // Named area of water mostly surrounded by land but with level connection to the ocean or a lake.
				BEACH("beach"),                     // landform along a body of water which consists of sand, shingle or other loose material
				BLOWHOLE("blowhole"),               // An opening to a sea cave which has grown landwards resulting in blasts of water from the opening due to the wave action.
				CAPE("cape"),                       // A piece of elevated land sticking out into the sea or large lake.
				COASTLINE("coastline"),             // The mean high water (springs) line between the sea and land (with the water on the right side of the way)
				CREVASSE("crevasse"),               // A large crack in a glacier
				GEYSER("geyser"),                   // A spring characterized by intermittent discharge of water ejected turbulently and accompanied by steam
				GLACIER("glacier"),                 // A permanent body of ice formed naturally from snow that is moving under its own weight.
				HOT_SPRING("hot_spring"),           // A spring of geothermally heated groundwater
				ISTHMUS("isthmus"),                 // A narrow strip of land, bordered by water on both sides and connecting two larger land masses
				MUD("mud"),                         // Area covered with mud: water saturated fine grained soil without significant plant growth.
				PENINSULA("peninsula"),             // A piece of land projecting into water from a larger land mass, nearly surrounded by water
				REEF("reef"),                       // A feature (rock, sandbar, coral, etc) lying permanently beneath the surface of the water.
				SHINGLE("shingle"),                 // An accumulation of rounded rock fragments on a beach or riverbed
				SHOAL("shoal"),                     // An area of the water floor which nears the water surface and is exposed at low tide or when a river/lake is not full of water.
				SPRING("spring"),                   // A place where ground water flows naturally from the ground
				STRAIT("strait"),                   // A narrow area of water surrounded by land on two sides and by water on two other sides.
				WATER("water"),                     // Any inland body of water, from natural such as a lake or pond to artificial like a moat or canal.
				WETLAND("wetland"),                 // A natural area subject to inundation or with waterlogged ground
				ARCH("arch"),                       // A rock arch naturally formed by erosion, with an opening underneath.
				ARETE("arete"),                     // A thin, almost knife-like, ridge of rock which is typically formed when two glaciers erode parallel U-shaped valleys
				BARE_ROCK("bare_rock"),             // An area with sparse or no vegetation, so that the bedrock becomes visible
				BLOCKFIELD("blockfield"),           // A pile of rocks, often formed as a result of volcanic or glacial activity.
				CAVE_ENTRANCE("cave_entrance"),     // An entrance to a cave: a natural underground space large enough for a human to enter
				CLIFF("cliff"),                     // A vertical or almost vertical natural drop in terrain, usually with a bare rock surface. The bottom of the cliff is on the right side of the way.
				DUNE("dune"),                       // A hill of sand formed by wind, covered with no or very little vegetation
				EARTH_BANK("earth_bank"),           // Large erosion gully or steep earth bank.
				FUMAROLE("fumarole"),               // A fumarole is an opening in a planet's crust, which emits steam and gases
				HILL("hill"),                       // A hill is a landform that is elevated above the surrounding terrain, but is smaller than a mountain.
				PEAK("peak"),                       // The top (summit) of a hill or mountain.
				RIDGE("ridge"),                     // A mountain landform with a continuous elevated crest or linear hill
				ROCK("rock"),                       // A notable rock or group of rocks attached to the underlying bedrock
				SADDLE("saddle"),                   // The lowest point along a ridge or between two mountain tops
				SAND("sand"),                       // An area covered by sand with no or very little vegetation.
				SCREE("scree"),                     // Unconsolidated angular stones formed by rockfall and weathering from adjacent rockfaces
				SINKHOLE("sinkhole"),               // A natural depression or hole in the surface topography.
				STONE("stone"),                     // A single notable freestanding rock, which may differ from the composition of the terrain it lies in.
				VALLEY("valley"),                   // A natural depression flanked by ridges or ranges of mountains or hills
				VOLCANO("volcano"),                 // An opening exposed on the earth's surface where volcanic material is emitted.
                OTHER("other")
            }