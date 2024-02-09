package com.urosjarc.mapmaster.domain

data class Maxlength(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		LENGTH("Length"),                   // Length limit – units other than metres should be explicit
	}
}