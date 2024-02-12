			package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
            /**
             * This file is auto generated!
             */

            data class AmenityNode(
                val node: OsmNode,
                val type: AmenityType
            )

            data class AmenityWay(
                val way: OsmWay,
                val type: AmenityType
            )

            data class AmenityRel(
                val rel: OsmRel,
                val type: AmenityType
            )

            data class AmenityFeatures(
                val nodes: MutableList<AmenityNode> = mutableListOf(),
                val ways: MutableList<AmenityWay> = mutableListOf(),
                val rels: MutableList<AmenityRel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["amenity"]
                    val type = AmenityType.entries.firstOrNull { it.value == enumValue }
                        ?: AmenityType.OTHER
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(AmenityNode(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(AmenityRel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(AmenityWay(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class AmenityType(val value: String) {
                BAR("bar"),                         // Bar is a purpose-built commercial establishment that sells alcoholic drinks to be consumed on the premises. They are characterised by a noisy and vibrant atmosphere, similar to a party and usually don't sell food. See also the description of the tags amenity=pub;bar;restaurant for a distinction between these.
				BIERGARTEN("biergarten"),           // Biergarten or beer garden is an open-air area where alcoholic beverages along with food is prepared and served. See also the description of the tags amenity=pub;bar;restaurant. A biergarten can commonly be found attached to a beer hall, pub, bar, or restaurant. In this case, you can use biergarten=yes additional to amenity=pub;bar;restaurant.
				CAFE("cafe"),                       // Cafe is generally an informal place that offers casual meals and beverages; typically, the focus is on coffee or tea. Also known as a coffeehouse/shop, bistro or sidewalk cafe. The kind of food served may be mapped with the tags cuisine=* and diet:*=*. See also the tags amenity=restaurant;bar;fast_food.
				FAST_FOOD("fast_food"),             // Fast food restaurant (see also amenity=restaurant). The kind of food served can be tagged with cuisine=* and diet:*=*.
				FOOD_COURT("food_court"),           // An area with several different restaurant food counters and a shared eating area. Commonly found in malls, airports, etc.
				ICE_CREAM("ice_cream"),             // Ice cream shop or ice cream parlour. A place that sells ice cream and frozen yoghurt over the counter
				PUB("pub"),                         // A place selling beer and other alcoholic drinks; may also provide food or accommodation (UK). See description of amenity=bar and amenity=pub for distinction between bar and pub
				RESTAURANT("restaurant"),           // Restaurant (not fast food, see amenity=fast_food). The kind of food served can be tagged with cuisine=* and diet:*=*.
				COLLEGE("college"),                 // Campus or buildings of an institute of Further Education (aka continuing education)
				DANCING_SCHOOL("dancing_school"),   // A dancing school or dance studio
				DRIVING_SCHOOL("driving_school"),   // Driving School which offers motor vehicle driving lessons
				FIRST_AID_SCHOOL("first_aid_school"), // A place where people can go for first aid courses.
				KINDERGARTEN("kindergarten"),       // For children too young for a regular school (also known as preschool, playschool or nursery school), in some countries including afternoon supervision of primary school children.
				LANGUAGE_SCHOOL("language_school"), // Language School: an educational institution where one studies a foreign language.
				LIBRARY("library"),                 // A public library (municipal, university, …) to borrow books from.
				SURF_SCHOOL("surf_school"),         // A surf school is an establishment that teaches surfing.
				TOY_LIBRARY("toy_library"),         // A place to borrow games and toys, or play with them on site.
				RESEARCH_INSTITUTE("research_institute"), // An establishment endowed for doing research.
				TRAINING("training"),               // Public place where you can get training.
				MUSIC_SCHOOL("music_school"),       // A music school, an educational institution specialized in the study, training, and research of music.
				SCHOOL("school"),                   // School and grounds - primary, middle and seconday schools
				TRAFFIC_PARK("traffic_park"),       // Juvenile traffic schools
				UNIVERSITY("university"),           // An university campus: an institute of higher education
				BICYCLE_PARKING("bicycle_parking"), // Parking for bicycles
				BICYCLE_REPAIR_STATION("bicycle_repair_station"), // General tools for self-service bicycle repairs, usually on the roadside; no service
				BICYCLE_RENTAL("bicycle_rental"),   // Rent a bicycle
				BICYCLE_WASH("bicycle_wash"),       // Clean a bicycle
				BOAT_RENTAL("boat_rental"),         // Rent a Boat
				BOAT_SHARING("boat_sharing"),       // Share a Boat
				BUS_STATION("bus_station"),         // May also be tagged as public_transport=station.
				CAR_RENTAL("car_rental"),           // Rent a car
				CAR_SHARING("car_sharing"),         // Share a car
				CAR_WASH("car_wash"),               // Wash a car
				COMPRESSED_AIR("compressed_air"),   // A device to inflate tires/tyres (e.g. motorcar, bicycle)
				VEHICLE_INSPECTION("vehicle_inspection"), // Government vehicle inspection
				CHARGING_STATION("charging_station"), // Charging facility for electric vehicles
				DRIVER_TRAINING("driver_training"), // A place for driving training on a closed course
				FERRY_TERMINAL("ferry_terminal"),   // Ferry terminal/stop. A place where people/cars/etc. can board and leave a ferry.
				FUEL("fuel"),                       // Petrol station; gas station; marine fuel; … Streets to petrol stations are often tagged highway=service.
				GRIT_BIN("grit_bin"),               // A container that holds grit or a mixture of salt and grit.
				MOTORCYCLE_PARKING("motorcycle_parking"), // Parking for motorcycles
				PARKING("parking"),                 // Car park. Nodes and areas (without access tag) will get a parking symbol. Areas will be coloured. Streets on car parking are often tagged highway=service and service=parking_aisle.
				PARKING_ENTRANCE("parking_entrance"), // An entrance or exit to an underground or multi-storey parking facility. Group multiple parking entrances together with a relation using the tags type=site and site=parking. Do not mix with amenity=parking.
				PARKING_SPACE("parking_space"),     // A single parking space. Group multiple parking spaces together with a relation using the tags type=site and site=parking. Do not mix with amenity=parking.
				TAXI("taxi"),                       // A place where taxis wait for passengers.
				WEIGHBRIDGE("weighbridge"),         // A large weight scale to weigh vehicles and goods
				ATM("atm"),                         // ATM or cash point: a device that provides the clients of a financial institution with access to financial transactions.
				PAYMENT_TERMINAL("payment_terminal"), // Self-service payment kiosk/terminal
				BANK("bank"),                       // Bank or credit union: a financial establishment where customers can deposit and withdraw money, take loans, make investments and transfer funds.
				BUREAU_DE_CHANGE("bureau_de_change"), // Bureau de change, money changer, currency exchange, Wechsel, cambio – a place to change foreign bank notes and travellers cheques.
				MONEY_TRANSFER("money_transfer"),   // A place that offers money transfers, especially cash to cash
				PAYMENT_CENTRE("payment_centre"),   // A non-bank place, where people can pay bills of public and private services and taxes.
				BABY_HATCH("baby_hatch"),           // A place where a baby can be, out of necessity, anonymously left to be safely cared for and perhaps adopted.
				CLINIC("clinic"),                   // A medium-sized medical facility or health centre.
				DENTIST("dentist"),                 // A dentist practice / surgery.
				DOCTORS("doctors"),                 // A doctor's practice / surgery.
				HOSPITAL("hospital"),               // A hospital providing in-patient medical treatment. Often used in conjunction with emergency=* to note whether the medical centre has emergency facilities (A&E (brit.) or ER (am.))
				NURSING_HOME("nursing_home"),       // Discouraged tag for a home for disabled or elderly persons who need permanent care. Use amenity=social_facility + social_facility=nursing_home now.
				PHARMACY("pharmacy"),               // Pharmacy: a shop where a pharmacist sells medications dispensing=yes/no - availability of prescription-only medications
				SOCIAL_FACILITY("social_facility"), // A facility that provides social services: group & nursing homes, workshops for the disabled, homeless shelters, etc.
				VETERINARY("veterinary"),           // A place where a veterinary surgeon, also known as a veterinarian or vet, practices.
				ARTS_CENTRE("arts_centre"),         // A venue where a variety of arts are performed or conducted
				BROTHEL("brothel"),                 // An establishment specifically dedicated to prostitution
				CASINO("casino"),                   // A gambling venue with at least one table game(e.g. roulette, blackjack) that takes bets on sporting and other events at agreed upon odds.
				CINEMA("cinema"),                   // A place where films are shown (US: movie theater)
				COMMUNITY_CENTRE("community_centre"), // A place mostly used for local events, festivities and group activities; including special interest and special age groups. .
				CONFERENCE_CENTRE("conference_centre"), // A large building that is used to hold a convention
				EVENTS_VENUE("events_venue"),       // A building specifically used for organising events
				EXHIBITION_CENTRE("exhibition_centre"), // An exhibition centre
				FOUNTAIN("fountain"),               // A fountain for cultural / decorational / recreational purposes.
				GAMBLING("gambling"),               // A place for gambling, not being a shop=bookmaker, shop=lottery, amenity=casino, or leisure=adult_gaming_centre. Games that are covered by this definition include bingo and pachinko.
				LOVE_HOTEL("love_hotel"),           // A love hotel is a type of short-stay hotel operated primarily for the purpose of allowing guests privacy for sexual activities.
				MUSIC_VENUE("music_venue"),         // An indoor place to hear contemporary live music.
				NIGHTCLUB("nightclub"),             // A place to drink and dance (nightclub). The German word is "Disco" or "Discothek". Please don't confuse this with the German "Nachtclub" which is most likely amenity=stripclub.
				PLANETARIUM("planetarium"),         // A planetarium.
				PUBLIC_BOOKCASE("public_bookcase"), // A street furniture containing books. Take one or leave one.
				SOCIAL_CENTRE("social_centre"),     // A place for free and not-for-profit activities.
				STRIPCLUB("stripclub"),             // A place that offers striptease or lapdancing (for sexual services use amenity=brothel).
				STUDIO("studio"),                   // TV radio or recording studio
				SWINGERCLUB("swingerclub"),         // A club where people meet to have a party and group sex.
				THEATRE("theatre"),                 // A theatre or opera house where live performances occur, such as plays, musicals and formal concerts. Use amenity=cinema for movie theaters.
				COURTHOUSE("courthouse"),           // A building home to a court of law, where justice is dispensed
				FIRE_STATION("fire_station"),       // A station of a fire brigade
				POLICE("police"),                   // A police station where police officers patrol from and that is a first point of contact for civilians
				POST_BOX("post_box"),               // A box for the reception of mail. Alternative mail-carriers can be tagged via operator=*
				POST_DEPOT("post_depot"),           // Post depot or delivery office, where letters and parcels are collected and sorted prior to delivery.
				POST_OFFICE("post_office"),         // Post office building with postal services
				PRISON("prison"),                   // A prison or jail where people are incarcerated before trial or after conviction
				RANGER_STATION("ranger_station"),   // National Park visitor headquarters: official park visitor facility with police, visitor information, permit services, etc
				TOWNHALL("townhall"),               // Building where the administration of a village, town or city may be located, or just a community meeting place
				BBQ("bbq"),                         // BBQ or Barbecue is a permanently built grill for cooking food, which is most typically used outdoors by the public. For example these may be found in city parks or at beaches. Use the tag fuel=* to specify the source of heating, such as fuel=wood;electric;charcoal. For mapping nearby table and chairs, see also the tag tourism=picnic_site. For mapping campfires and firepits, instead use the tag leisure=firepit.
				BENCH("bench"),                     // A bench to sit down and relax a bit
				DOG_TOILET("dog_toilet"),           // Area designated for dogs to urinate and excrete.
				DRESSING_ROOM("dressing_room"),     // Area designated for changing clothes.
				DRINKING_WATER("drinking_water"),   // Drinking water is a place where humans can obtain potable water for consumption. Typically, the water is used for only drinking. Also known as a drinking fountain or bubbler.
				GIVE_BOX("give_box"),               // A small facility where people drop off and pick up various types of items in the sense of free sharing and reuse.
				MAILROOM("mailroom"),               // A mailroom for receiving packages or letters.
				PARCEL_LOCKER("parcel_locker"),     // Machine for picking up and sending parcels
				SHELTER("shelter"),                 // A small shelter against bad weather conditions. To additionally describe the kind of shelter use shelter_type=*.
				SHOWER("shower"),                   // Public shower.
				TELEPHONE("telephone"),             // Public telephone
				TOILETS("toilets"),                 // Public toilets (might require a fee)
				WATER_POINT("water_point"),         // Place where you can get large amounts of drinking water
				WATERING_PLACE("watering_place"),   // Place where water is contained and animals can drink
				SANITARY_DUMP_STATION("sanitary_dump_station"), // A place for depositing human waste from a toilet holding tank.
				RECYCLING("recycling"),             // Recycling facilities (bottle banks, etc.). Combine with recycling_type=container for containers or recycling_type=centre for recycling centres.
				WASTE_BASKET("waste_basket"),       // A single small container for depositing garbage that is easily accessible for pedestrians.
				WASTE_DISPOSAL("waste_disposal"),   // A medium or large disposal bin, typically for bagged up household or industrial waste.
				WASTE_TRANSFER_STATION("waste_transfer_station"), // A waste transfer station is a location that accepts, consolidates and transfers waste in bulk.
				ANIMAL_BOARDING("animal_boarding"), // A facility where you, paying a fee, can bring your animal for a limited period of time (e.g. for holidays)
				ANIMAL_BREEDING("animal_breeding"), // A facility where animals are bred, usually to sell them
				ANIMAL_SHELTER("animal_shelter"),   // A shelter that recovers animals in trouble
				ANIMAL_TRAINING("animal_training"), // A facility used for non-competitive animal training
				BAKING_OVEN("baking_oven"),         // An oven used for baking bread and similar, for example inside a building=bakehouse.
				CLOCK("clock"),                     // A public visible clock
				CREMATORIUM("crematorium"),         // A place where dead human bodies are burnt
				DIVE_CENTRE("dive_centre"),         // A dive center is the base location where sports divers usually start scuba diving or make dive guided trips at new locations.
				FUNERAL_HALL("funeral_hall"),       // A place for holding a funeral ceremony, other than a place of worship.
				GRAVE_YARD("grave_yard"),           // A (smaller) place of burial, often you'll find a church nearby. Large places should be landuse=cemetery instead.
				HUNTING_STAND("hunting_stand"),     // A hunting stand: an open or enclosed platform used by hunters to place themselves at an elevated height above the terrain
				INTERNET_CAFE("internet_cafe"),     // A place whose principal role is providing internet services to the public.
				KITCHEN("kitchen"),                 // A public kitchen in a facility to use by everyone or customers
				KNEIPP_WATER_CURE("kneipp_water_cure"), // Outdoor foot bath facility. Usually this is a pool with cold water and handrail. Popular in German speaking countries.
				LOUNGER("lounger"),                 // An object for people to lie down.
				MARKETPLACE("marketplace"),         // A marketplace where goods and services are traded daily or weekly.
				MONASTERY("monastery"),             // Monastery is the location of a monastery or a building in which monks and nuns live.
				MORTUARY("mortuary"),               // A morgue or funeral home, used for the storage of human corpses
				PHOTO_BOOTH("photo_booth"),         // A stand to create instant photos.
				PLACE_OF_MOURNING("place_of_mourning"), // A room or building where families and friends can come, before the funeral, and view the body of the person who has died.
				PLACE_OF_WORSHIP("place_of_worship"), // A church, mosque, or temple, etc. Note that you also need religion=*, usually denomination=* and preferably name=* as well as amenity=place_of_worship. See the article for details.
				PUBLIC_BATH("public_bath"),         // A location where the public may bathe in common, etc. japanese onsen, turkish bath, hot spring
				PUBLIC_BUILDING("public_building"), // A generic public building. Don't use! See office=government.
				REFUGEE_SITE("refugee_site"),       // A human settlement sheltering refugees or internally displaced persons
				VENDING_MACHINE("vending_machine"), // A machine selling goods – food, tickets, newspapers, etc. Add type of goods using vending=*
                OTHER("other")
            }