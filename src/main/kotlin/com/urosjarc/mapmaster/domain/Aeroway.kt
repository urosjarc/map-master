package com.urosjarc.mapmaster.domain

data class Aeroway(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
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
	}
}