package com.urosjarc.mapmaster.domain

data class Footway(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		SIDEWALK("sidewalk"),               // Sidewalk that runs typically along residential road. Use in combination with highway=footway or highway=path
		CROSSING("crossing"),               // Crosswalk that connects two sidewalks on the opposite side of the road. Often recognized by painted markings on the road, road sign or traffic lights. Use in combination with highway=footway or highway=path. Useful information is presence of tactile_paving=*, wheelchair=* suitability and kerb=* represented as a node on the crosswalk way.
	}
}