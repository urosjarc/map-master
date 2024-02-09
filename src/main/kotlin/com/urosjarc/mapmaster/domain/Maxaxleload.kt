package com.urosjarc.mapmaster.domain

data class Maxaxleload(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		WEIGHT("Weight"),                   // The legal maximum axleload – units other than tonnes should be explicit
	}
}