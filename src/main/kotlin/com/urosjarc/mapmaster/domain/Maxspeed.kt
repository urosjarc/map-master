package com.urosjarc.mapmaster.domain

data class Maxspeed(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		SPEED("Speed"),                     // Maximum speed – units other than km/h should be explicit
	}
}