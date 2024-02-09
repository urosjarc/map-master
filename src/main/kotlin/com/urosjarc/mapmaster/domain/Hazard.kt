package com.urosjarc.mapmaster.domain

data class Hazard(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		HAZARD("hazard"),                   // Indicates of the hazards.
	}
}