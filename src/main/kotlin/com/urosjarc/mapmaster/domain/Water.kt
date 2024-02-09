package com.urosjarc.mapmaster.domain

data class Water(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		RIVER("river"),                     // The water covered area of a river
		OXBOW("oxbow"),                     // An oxbow lake
		CANAL("canal"),                     // The area covered by the water of a canal
		DITCH("ditch"),                     // The water covered area of a waterway=ditch - a simple artificial waterway serving as a barrier or for draining surrounding land.
		LOCK("lock"),                       // Water area of the lock chamber
		FISH_PASS("fish_pass"),             // Area of a fish pass for the fish to pass waterway dams or weirs. Should contain tag:waterway=fish_pass way inside.
		LAKE("lake"),                       // A natural or semi-natural body of relatively still fresh or salt water which is surrounded by land.
		RESERVOIR("reservoir"),             // An artificial lake which may be used to store water. Usually formed by a dam over a natural water course.
		POND("pond"),                       // A small body of standing water, man-made in most cases
		BASIN("basin"),                     // An area of land artificially graded to hold water.
		LAGOON("lagoon"),                   // A body of shallow sea water or brackish water separated from the sea by a barrier.
		STREAM_POOL("stream_pool"),         // A stream pool: a small but relatively deep collection of fresh water, occurring along a narrow stream
		REFLECTING_POOL("reflecting_pool"), // A shallow pool of water, undisturbed by fountain jets, for a calm reflective surface, often found in gardens, squares or at memorial sites
		MOAT("moat"),                       // A deep, wide defensive ditch, normally filled with water, dug to surround a fortified habitation.
		WASTEWATER("wastewater"),           // A clarifier or settling basin of a wastewater treatment plant.
	}
}