package com.urosjarc.mapmaster.domain

data class Military(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		ACADEMY("academy"),                 // A training establishment for military service members
		AIRFIELD("airfield"),               // A place where military planes take off and land.
		BASE("base"),                       // A facility where military personnel and equipment are based.
		BUNKER("bunker"),                   // A building reinforced to withstand attack
		BARRACKS("barracks"),               // Buildings where military personnel live and sleep
		CHECKPOINT("checkpoint"),           // Place where civilian visitors and vehicles will be checked by a military authority.
		DANGER_AREA("danger_area"),         // A danger area is a restricted area posing a threat to life or property.
		NUCLEAR_EXPLOSION_SITE("nuclear_explosion_site"), // Nuclear weapons test site
		OBSTACLE_COURSE("obstacle_course"), // A military obstacle course: a series of challenging physical obstructions an individual or team must navigate usually while being timed
		OFFICE("office"),                   // Military offices, e.g. general staff office, military recruitment office etc
		RANGE("range"),                     // Where military personnel practice with their weapons (firing, bombing, artillery, …)
		SCHOOL("school"),                   // A school for children run as part of a country's military
		TRAINING_AREA("training_area"),     // A military training area/proving ground
		TRENCH("trench"),                   // A military trench: an excavation in the ground that is generally deeper than it is wide, dug into the ground as a barrier for military purposes (e.g. trench warfare)
	}
}