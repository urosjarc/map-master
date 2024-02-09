package com.urosjarc.mapmaster.domain

data class Busway(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		LANE("lane"),                       // Bus lane on both sides of the road. (See also: Parallel scheme for bus/psv lane tagging lanes:bus=* / lanes:psv=*)
	}
}