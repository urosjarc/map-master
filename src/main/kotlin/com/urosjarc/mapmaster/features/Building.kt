			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class BuildingNode(
                val node: OsmNode,
                val type: BuildingType
            )

            data class BuildingWay(
                val way: OsmWay,
                val type: BuildingType
            )

            data class BuildingRel(
                val rel: OsmRel,
                val type: BuildingType
            )

            data class BuildingFeatures(
                val nodes: MutableList<BuildingNode> = mutableListOf(),
                val ways: MutableList<BuildingWay> = mutableListOf(),
                val rels: MutableList<BuildingRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["building"]
                    val type = BuildingType.entries.firstOrNull { it.value == enumValue }
                        ?: BuildingType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(BuildingNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(BuildingRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(BuildingWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class BuildingType(val value: String) {
                APARTMENTS("apartments"),           
				BARRACKS("barracks"),               
				BUNGALOW("bungalow"),               
				CABIN("cabin"),                     
				DETACHED("detached"),               
				DORMITORY("dormitory"),             
				FARM("farm"),                       
				GER("ger"),                         
				HOTEL("hotel"),                     
				HOUSE("house"),                     
				HOUSEBOAT("houseboat"),             
				RESIDENTIAL("residential"),         
				SEMIDETACHED_HOUSE("semidetached_house"), 
				STATIC_CARAVAN("static_caravan"),   
				STILT_HOUSE("stilt_house"),         
				TERRACE("terrace"),                 
				TREE_HOUSE("tree_house"),           
				TRULLO("trullo"),                   
				COMMERCIAL("commercial"),           
				INDUSTRIAL("industrial"),           
				KIOSK("kiosk"),                     
				OFFICE("office"),                   
				RETAIL("retail"),                   
				SUPERMARKET("supermarket"),         
				WAREHOUSE("warehouse"),             
				RELIGIOUS("religious"),             
				CATHEDRAL("cathedral"),             
				CHAPEL("chapel"),                   
				CHURCH("church"),                   
				KINGDOM_HALL("kingdom_hall"),       
				MONASTERY("monastery"),             
				MOSQUE("mosque"),                   
				PRESBYTERY("presbytery"),           
				SHRINE("shrine"),                   
				SYNAGOGUE("synagogue"),             
				TEMPLE("temple"),                   
				BAKEHOUSE("bakehouse"),             
				BRIDGE("bridge"),                   
				CIVIC("civic"),                     
				COLLEGE("college"),                 
				FIRE_STATION("fire_station"),       
				GOVERNMENT("government"),           
				GATEHOUSE("gatehouse"),             
				HOSPITAL("hospital"),               
				KINDERGARTEN("kindergarten"),       
				MUSEUM("museum"),                   
				PUBLIC("public"),                   
				SCHOOL("school"),                   
				TOILETS("toilets"),                 
				TRAIN_STATION("train_station"),     
				TRANSPORTATION("transportation"),   
				UNIVERSITY("university"),           
				BARN("barn"),                       
				CONSERVATORY("conservatory"),       
				COWSHED("cowshed"),                 
				FARM_AUXILIARY("farm_auxiliary"),   
				GREENHOUSE("greenhouse"),           
				SLURRY_TANK("slurry_tank"),         
				STABLE("stable"),                   
				STY("sty"),                         
				LIVESTOCK("livestock"),             
				GRANDSTAND("grandstand"),           
				PAVILION("pavilion"),               
				RIDING_HALL("riding_hall"),         
				SPORTS_HALL("sports_hall"),         
				SPORTS_CENTRE("sports_centre"),     
				STADIUM("stadium"),                 
				ALLOTMENT_HOUSE("allotment_house"), 
				BOATHOUSE("boathouse"),             
				HANGAR("hangar"),                   
				HUT("hut"),                         
				SHED("shed"),                       
				CARPORT("carport"),                 
				GARAGE("garage"),                   
				GARAGES("garages"),                 
				PARKING("parking"),                 
				DIGESTER("digester"),               
				SERVICE("service"),                 
				TECH_CAB("tech_cab"),               
				TRANSFORMER_TOWER("transformer_tower"), 
				WATER_TOWER("water_tower"),         
				STORAGE_TANK("storage_tank"),       
				SILO("silo"),                       
				BEACH_HUT("beach_hut"),             
				BUNKER("bunker"),                   
				CASTLE("castle"),                   
				CONSTRUCTION("construction"),       
				CONTAINER("container"),             
				GUARDHOUSE("guardhouse"),           
				MILITARY("military"),               
				OUTBUILDING("outbuilding"),         
				PAGODA("pagoda"),                   
				QUONSET_HUT("quonset_hut"),         
				ROOF("roof"),                       
				RUINS("ruins"),                     
				TOWER("tower"),                     
				WINDMILL("windmill"),               
				YES("yes"),                         
                OTHER("other")
            }