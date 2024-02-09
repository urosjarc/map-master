package com.urosjarc.mapmaster.domain

data class Maxwidth(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		WIDTH("Width"),                     // Width limit – units other than metres should be explicit
	}
}