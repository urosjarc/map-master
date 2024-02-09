package com.urosjarc.mapmaster.domain

data class Place(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		COUNTRY("country"),                 // A nation state or other high-level national political/administrative area.
		STATE("state"),                     // A large sub-national political/administrative area.
		REGION("region"),                   // Used both as a broad tag for geographic or historical areas with no clear boundary and for distinct administration areas (with specific boundaries) in some countries.
		PROVINCE("province"),               // A subdivision of a country similar to a state
		DISTRICT("district"),               // A district - a type of administrative division that, in some countries, is managed by local government.
		COUNTY("county"),                   // A county - a geographical region of a country.
		MUNICIPALITY("municipality"),       // A municipality - single urban administrative division having corporate status.
		CITY("city"),                       // The largest urban settlement or settlements within the territory.
		BOROUGH("borough"),                 // A part in larger city grouped into administrative unit.
		SUBURB("suburb"),                   // A part of a town or city with a well-known name and often a distinct identity.
		QUARTER("quarter"),                 // A quarter is a named, geographically localised place within a suburb of a larger city or within a town which is bigger than a neighbourhood
		NEIGHBOURHOOD("neighbourhood"),     // A neighbourhood is a smaller named, geographically localised place within a suburb of a larger city or within a town or village
		CITY_BLOCK("city_block"),           // A named city block, usually surrounded by streets.
		PLOT("plot"),                       // A named plot is a tract or parcel of land owned or meant to be owned by some owner.
		TOWN("town"),                       // An important urban centre, between a village and a city in size.
		VILLAGE("village"),                 // A smaller distinct settlement, smaller than a town with few facilities available with people traveling to nearby towns to access these.
		HAMLET("hamlet"),                   // A smaller rural community, typically with fewer than 100-1000 inhabitants, and little infrastructure.
		ISOLATED_DWELLING("isolated_dwelling"), // The smallest kind of settlement (1-2 households).
		FARM("farm"),                       // An individually named farm.
		ALLOTMENTS("allotments"),           // A separate settlement, which is located outside an officially inhabited locality and has its own addressing
		CONTINENT("continent"),             // One of the seven continents: Africa, Antarctica, Asia, Europe, North America, Oceania, South America.
		ARCHIPELAGO("archipelago"),         // A named group or chain of closely related islands and islets.
		ISLAND("island"),                   // Any piece of land that is completely surrounded by water and isolated from other significant landmasses.
		ISLET("islet"),                     // A very small island.
		SQUARE("square"),                   // A town or village square: a (typically) paved open space, generally of architectural significance, which is surrounded by buildings in a built-up area such as a city, town or village.
		LOCALITY("locality"),               // A named place that has no population.
		POLDER("polder"),                   // A polder.
		SEA("sea"),                         // A part of an ocean.
		OCEAN("ocean"),                     // The world's five main major oceanic divisions.
	}
}