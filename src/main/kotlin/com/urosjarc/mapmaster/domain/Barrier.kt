package com.urosjarc.mapmaster.domain

data class Barrier(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		CABLE_BARRIER("cable_barrier"),     // A road side or median barrier made of steel wire ropes mounted on weak posts.
		CITY_WALL("city_wall"),             // A fortification used to defend settlements in ancient to modern times.
		DITCH("ditch"),                     // A man made ditch or trench to prevent access to the other side.
		FENCE("fence"),                     // A freestanding structure designed to restrict or prevent movement across a boundary, generally distinguished from a wall by the lightness of its construction.
		GUARD_RAIL("guard_rail"),           // A rail, typically metal, designed to keep vehicles within their roadway and prevent dangerous collisions
		HANDRAIL("handrail"),               // A rail designed to be grasped by the hand so as to provide stability or support.
		HEDGE("hedge"),                     // A line of closely spaced shrubs and tree species, which form a barrier or mark the boundary of an area.
		KERB("kerb"),                       // A stone edging to a pavement or raised path (right side is bottom, left side is top).
		RETAINING_WALL("retaining_wall"),   // A structure that holds back soil or rock from a building, structure or area.
		WALL("wall"),                       // A freestanding structure, designed to restrict or prevent movement across a boundary, typically made from solid brick, concrete or rocks, and almost always built so that it is opaque to vision.
		BLOCK("block"),                     // One or more large immobile block(s) usually barring free access along a way.
		BOLLARD("bollard"),                 // One or more solid (usually concrete or metal) pillar(s) used to control traffic.
		BORDER_CONTROL("border_control"),   // A control point at an international border between two countries.
		BUMP_GATE("bump_gate"),             // A drive-through gate used in rural areas to provide a barrier to livestock that does not require the driver to exit the vehicle.
		BUS_TRAP("bus_trap"),               // A short section of the roadway where there is a deep dip in the middle to prevent passage by some traffic.
		CATTLE_GRID("cattle_grid"),         // A hole in the road surface covered in a series of bars that allow wheeled vehicles but not animals to cross.
		CHAIN("chain"),                     // A chain used to prevent motorised vehicles.
		CYCLE_BARRIER("cycle_barrier"),     // A barrier along a path that slows or prevents access for bicycle users.
		DEBRIS("debris"),                   // Debris blocking a road
		ENTRANCE("entrance"),               // An opening or gap in a barrier.
		FULL_HEIGHT_TURNSTILE("full-height_turnstile"), // A full-height turnstile.
		GATE("gate"),                       // A section in a wall or fence which can be opened to allow access.
		HAMPSHIRE_GATE("hampshire_gate"),   // A section of wire fence which can be removed temporarily.
		HEIGHT_RESTRICTOR("height_restrictor"), // A height restrictor which prevents access of vehicles higher than a set limit.
		HORSE_STILE("horse_stile"),         // A horse stile allows pedestrians and horses to cross a gap through a fence
		JERSEY_BARRIER("jersey_barrier"),   // A barrier made of heavy prefabricated blocks.
		KISSING_GATE("kissing_gate"),       // A type of gate where you have to go into an enclosure and open a gate to get through.
		LIFT_GATE("lift_gate"),             // A bar or pole pivoted (rotates upwards to open) in such a way as to allow the boom to block vehicular access through a controlled point.
		LOG("log"),                         // A log blocking access.
		MOTORCYCLE_BARRIER("motorcycle_barrier"), // A barrier along a path preventing access by motorcycles.
		ROPE("rope"),                       // A flexible barrier made of rope.
		SALLY_PORT("sally_port"),           // A secure, controlled entryway to a fortification or prison.
		SPIKES("spikes"),                   // Spikes on the ground preventing unauthorized access.
		STILE("stile"),                     // A structure which provides people a passage through or over a boundary via steps, ladders or narrow gaps.
		SUMP_BUSTER("sump_buster"),         // A barrier to stop cars (two tracked vehicles with less than a certain ground clearance and width between tracks).
		SWING_GATE("swing_gate"),           // A gate consisting of a bar or pole pivoted (rotates sidewards to open) in such a way as to allow the boom to block vehicular access through a controlled point.
		TOLL_BOOTH("toll_booth"),           // A place where a road usage toll or fee is collected.
		TURNSTILE("turnstile"),             // A turnstile, a passage on foot designed to allow one person at a time to pass
		YES("yes"),                         // Unspecific barrier value, it is always better to use more specific one if possible
	}
}