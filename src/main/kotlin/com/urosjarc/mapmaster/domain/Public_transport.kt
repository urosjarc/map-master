package com.urosjarc.mapmaster.domain

data class Public_transport(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		STOP_POSITION("stop_position"),     // The position on the street or rails where a public transport vehicle stops.
		PLATFORM("platform"),               // The place where passengers are waiting for the public transport vehicles.
		STATION("station"),                 // A station is an area designed to access public transport.
		STOP_AREA("stop_area"),             // A relation that contains all elements of a train, subway, monorail, tram, bus, trolleybus, aerialway, or ferry stop.
		STOP_AREA_GROUP("stop_area_group"), 
	}
}