package com.urosjarc.mapmaster.domain

data class Service(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		ALLEY("alley"),                     // See Key:service for more details.
		CROSSOVER("crossover"),             // Relatively short lengths of track which switch traffic from one parallel line to another
		SIDING("siding"),                   // Relatively short lengths of track, running parallel to (and connected to) a main route
		SPUR("spur"),                       // Relatively short lengths of track, built to give one company or entity access to a main or branch line.
		YARD("yard"),                       // Tracks within railway company operated marshalling or maintenance yards.
	}
}