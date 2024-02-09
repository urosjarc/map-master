package com.urosjarc.mapmaster.domain

data class Traffic_sign(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		CITY_LIMIT("city_limit"),           // Start/end sign of city limits, in most countries implies a specific "city maxspeed".
	}
}