package com.urosjarc.mapmaster.domain

data class Aerialway(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		CABLE_CAR("cable_car"),             // A cable car run. Just one or two large cars. The traction cable forms a loop, but the cars do not loop around, they just move up and down on their own side, rolling along static cables over which they are suspended.
		GONDOLA("gondola"),                 // An aerialway where the cabins go around in a circle.
		MIXED_LIFT("mixed_lift"),           // A mixed lift, containing both gondolas and chairs.
		CHAIR_LIFT("chair_lift"),           // An open chairlift run. These have a single seat to sit on and are open to the outside air.
		DRAG_LIFT("drag_lift"),             // An overhead tow-line for skiers and riders.
		T_BAR("t-bar"),                     // An overhead tow-line for skiers and riders with T-shaped carriers for two passengers.
		J_BAR("j-bar"),                     // J-bar lift or L-bar lift. Overhead tow-line for skiers and riders with carriers in J-shape.
		PLATTER("platter"),                 // An overhead tow-line for skiers and riders with platters.
		ROPE_TOW("rope_tow"),               // A tow-line for skiers and riders where passenger hold by hand or use special tow grabbers.
		MAGIC_CARPET("magic_carpet"),       // A ski lift for small children resembling a conveyor belt.
		ZIP_LINE("zip_line"),               // Zip line, gravity propelled aerial ropeslide like a flying fox or similar
		GOODS("goods"),                     // A cable supported lift for conveying goods, not passengers.
		PYLON("pylon"),                     // A pylon supporting the aerialway cable.
		STATION("station"),                 // A station where passengers and/or goods can enter and/or leave the aerialway
	}
}