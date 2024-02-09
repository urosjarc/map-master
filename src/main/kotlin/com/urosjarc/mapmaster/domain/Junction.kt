package com.urosjarc.mapmaster.domain

data class Junction(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		ROUNDABOUT("roundabout"),           // This automatically implies oneway=yes, the oneway direction is defined by the sequential ordering of nodes within the Way. This applies on a way, tagged with highway=* already.
	}
}