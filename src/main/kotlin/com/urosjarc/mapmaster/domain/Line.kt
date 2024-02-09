package com.urosjarc.mapmaster.domain

data class Line(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		BUSBAR("busbar"),                   // Identifies a power line as a busbar, the central connection in a substation
		BAY("bay"),                         // A power line within a substation which connects a circuit to a busbar.
	}
}