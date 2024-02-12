			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class ShopNode(
                val node: OsmNode,
                val type: ShopType
            )

            data class ShopWay(
                val way: OsmWay,
                val type: ShopType
            )

            data class ShopRel(
                val rel: OsmRel,
                val type: ShopType
            )

            data class ShopFeatures(
                val nodes: MutableList<ShopNode> = mutableListOf(),
                val ways: MutableList<ShopWay> = mutableListOf(),
                val rels: MutableList<ShopRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["shop"]
                    val type = ShopType.entries.firstOrNull { it.value == enumValue }
                        ?: ShopType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(ShopNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(ShopRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(ShopWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class ShopType(val value: String) {
                ALCOHOL("alcohol"),                 
				BAKERY("bakery"),                   
				BEVERAGES("beverages"),             
				BREWING_SUPPLIES("brewing_supplies"), 
				BUTCHER("butcher"),                 
				CHEESE("cheese"),                   
				CHOCOLATE("chocolate"),             
				COFFEE("coffee"),                   
				CONFECTIONERY("confectionery"),     
				CONVENIENCE("convenience"),         
				DELI("deli"),                       
				DAIRY("dairy"),                     
				FARM("farm"),                       
				FROZEN_FOOD("frozen_food"),         
				GREENGROCER("greengrocer"),         
				HEALTH_FOOD("health_food"),         
				ICE_CREAM("ice_cream"),             
				PASTA("pasta"),                     
				PASTRY("pastry"),                   
				SEAFOOD("seafood"),                 
				SPICES("spices"),                   
				TEA("tea"),                         
				WINE("wine"),                       
				WATER("water"),                     
				FOOD("food"),                       
				DEPARTMENT_STORE("department_store"), 
				GENERAL("general"),                 
				KIOSK("kiosk"),                     
				MALL("mall"),                       
				SUPERMARKET("supermarket"),         
				WHOLESALE("wholesale"),             
				BABY_GOODS("baby_goods"),           
				BAG("bag"),                         
				BOUTIQUE("boutique"),               
				CLOTHES("clothes"),                 
				FABRIC("fabric"),                   
				FASHION("fashion"),                 
				FASHION_ACCESSORIES("fashion_accessories"), 
				JEWELRY("jewelry"),                 
				LEATHER("leather"),                 
				SEWING("sewing"),                   
				SHOES("shoes"),                     
				SHOE_REPAIR("shoe_repair"),         
				TAILOR("tailor"),                   
				WATCHES("watches"),                 
				WOOL("wool"),                       
				CHARITY("charity"),                 
				SECOND_HAND("second_hand"),         
				VARIETY_STORE("variety_store"),     
				BEAUTY("beauty"),                   
				CHEMIST("chemist"),                 
				COSMETICS("cosmetics"),             
				EROTIC("erotic"),                   
				HAIRDRESSER("hairdresser"),         
				HAIRDRESSER_SUPPLY("hairdresser_supply"), 
				HEARING_AIDS("hearing_aids"),       
				HERBALIST("herbalist"),             
				MASSAGE("massage"),                 
				MEDICAL_SUPPLY("medical_supply"),   
				NUTRITION_SUPPLEMENTS("nutrition_supplements"), 
				OPTICIAN("optician"),               
				PERFUMERY("perfumery"),             
				TATTOO("tattoo"),                   
				AGRARIAN("agrarian"),               
				APPLIANCE("appliance"),             
				BATHROOM_FURNISHING("bathroom_furnishing"), 
				DOITYOURSELF("doityourself"),       
				ELECTRICAL("electrical"),           
				ENERGY("energy"),                   
				FIREPLACE("fireplace"),             
				FLORIST("florist"),                 
				GARDEN_CENTRE("garden_centre"),     
				GARDEN_FURNITURE("garden_furniture"), 
				GAS("gas"),                         
				GLAZIERY("glaziery"),               
				GROUNDSKEEPING("groundskeeping"),   
				HARDWARE("hardware"),               
				HOUSEWARE("houseware"),             
				LOCKSMITH("locksmith"),             
				PAINT("paint"),                     
				POTTERY("pottery"),                 
				SECURITY("security"),               
				TRADE("trade"),                     
				ANTIQUES("antiques"),               
				BED("bed"),                         
				CANDLES("candles"),                 
				CARPET("carpet"),                   
				CURTAIN("curtain"),                 
				DOORS("doors"),                     
				FLOORING("flooring"),               
				FURNITURE("furniture"),             
				HOUSEHOLD_LINEN("household_linen"), 
				INTERIOR_DECORATION("interior_decoration"), 
				KITCHEN("kitchen"),                 
				LIGHTING("lighting"),               
				TILES("tiles"),                     
				WINDOW_BLIND("window_blind"),       
				COMPUTER("computer"),               
				ELECTRONICS("electronics"),         
				HIFI("hifi"),                       
				MOBILE_PHONE("mobile_phone"),       
				RADIOTECHNICS("radiotechnics"),     
				TELECOMMUNICATION("telecommunication"), 
				VACUUM_CLEANER("vacuum_cleaner"),   
				PRINTER_INK("printer_ink"),         
				ATV("atv"),                         
				BICYCLE("bicycle"),                 
				BOAT("boat"),                       
				CAR("car"),                         
				CAR_REPAIR("car_repair"),           
				MOTORCYCLE_REPAIR("motorcycle_repair"), 
				CAR_PARTS("car_parts"),             
				CARAVAN("caravan"),                 
				FUEL("fuel"),                       
				FISHING("fishing"),                 
				SURF("surf"),                       
				HUNTING("hunting"),                 
				JETSKI("jetski"),                   
				MILITARY_SURPLUS("military_surplus"), 
				MOTORCYCLE("motorcycle"),           
				OUTDOOR("outdoor"),                 
				SCUBA_DIVING("scuba_diving"),       
				SKI("ski"),                         
				SNOWMOBILE("snowmobile"),           
				SPORTS("sports"),                   
				SWIMMING_POOL("swimming_pool"),     
				TRAILER("trailer"),                 
				TYRES("tyres"),                     
				ART("art"),                         
				CAMERA("camera"),                   
				COLLECTOR("collector"),             
				CRAFT("craft"),                     
				FRAME("frame"),                     
				GAMES("games"),                     
				MODEL("model"),                     
				MUSIC("music"),                     
				MUSICAL_INSTRUMENT("musical_instrument"), 
				PHOTO("photo"),                     
				TROPHY("trophy"),                   
				VIDEO("video"),                     
				VIDEO_GAMES("video_games"),         
				ANIME("anime"),                     
				BOOKS("books"),                     
				GIFT("gift"),                       
				LOTTERY("lottery"),                 
				NEWSAGENT("newsagent"),             
				STATIONERY("stationery"),           
				TICKET("ticket"),                   
				BOOKMAKER("bookmaker"),             
				CANNABIS("cannabis"),               
				COPYSHOP("copyshop"),               
				DRY_CLEANING("dry_cleaning"),       
				E_CIGARETTE("e-cigarette"),         
				FUNERAL_DIRECTORS("funeral_directors"), 
				INSURANCE("insurance"),             
				LAUNDRY("laundry"),                 
				MONEY_LENDER("money_lender"),       
				OUTPOST("outpost"),                 
				PARTY("party"),                     
				PAWNBROKER("pawnbroker"),           
				PEST_CONTROL("pest_control"),       
				PET("pet"),                         
				PET_GROOMING("pet_grooming"),       
				PYROTECHNICS("pyrotechnics"),       
				RELIGION("religion"),               
				STORAGE_RENTAL("storage_rental"),   
				TOBACCO("tobacco"),                 
				TOYS("toys"),                       
				TRAVEL_AGENCY("travel_agency"),     
				WEAPONS("weapons"),                 
				VACANT("vacant"),                   
				YES("yes"),                         
                OTHER("other")
            }