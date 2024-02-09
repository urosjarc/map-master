package com.urosjarc.mapmaster.domain

data class Lifeguard(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		TOWER("tower"),                     // A tower used by lifeguard to watch and supervise swimmers in order to prevent drownings and other dangers.
	}
}