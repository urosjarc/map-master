package com.urosjarc.mapmaster.domain

data class Entrance(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		YES("yes"),                         // An entrance in a building. Replaces the deprecated tag building=entrance.
	}
}