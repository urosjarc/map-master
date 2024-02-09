package com.urosjarc.mapmaster.domain

data class Man_made(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		ADIT("adit"),                       // A type of entrance to an underground mine which is horizontal or nearly horizontal.
		BEACON("beacon"),                   // A structure for signalling on land and sea
		BREAKWATER("breakwater"),           // A man-made structure designed to protect a shore or harbour from the sea and waves.
		BRIDGE("bridge"),                   // The outline of a bridge, grouping together all features for that bridge.
		BUNKER_SILO("bunker_silo"),         // An open-sided structure without a roof that can be used with vehicles to fill and empty them
		CARPET_HANGER("carpet_hanger"),     // A construction to hang carpets for cleaning with the help of carpet beaters.
		CHIMNEY("chimney"),                 // A tall distinctive vertical conduit for venting hot gases or smoke, normally found near power stations or large factories
		COLUMN("column"),                   // A column used to support a structure or for decoration.
		COMMUNICATIONS_TOWER("communications_tower"), // A huge tower for transmitting radio applications
		CRANE("crane"),                     // A stationary, permanent crane.
		CROSS("cross"),                     // Cross, especially one with little historical value
		CUTLINE("cutline"),                 // A straight line cut in a forest.
		CLEARCUT("clearcut"),               // An area where all trees have been uniformly cut down.
		DOVECOTE("dovecote"),               // A place where doves are farmed or stored.
		DYKE("dyke"),                       // An embankment built to restrict the flow of water or other liquids
		EMBANKMENT("embankment"),           // An artificial steep slope
		FLAGPOLE("flagpole"),               // A long pole built to hold a flag
		GASOMETER("gasometer"),             // A large container in which natural gas or town gas is stored near atmospheric pressure at ambient temperatures
		GOODS_CONVEYOR("goods_conveyor"),   // A conveyor system for transporting materials
		GROYNE("groyne"),                   // A rigid structure built from a shoreline or riverbank that interrupts water flow and limits the movement of sediment.
		GUARD_STONE("guard_stone"),         // A guard stone: a stone built onto or into the corner of a building or wall to prevent carriages from damaging the structure, often found on either side of an entrance to a laneway, or alongside a wall to protect it.
		KILN("kiln"),                       // A thermally insulated chamber used for processes such as burning, hardening, drying, or smelting.
		LIGHTHOUSE("lighthouse"),           // Tower that emits light to serve as a navigational aid at sea or on inland waterway
		MAST("mast"),                       // A mast is a vertical structure built to hold, for example, antennas.
		MINESHAFT("mineshaft"),             // A mineshaft: vertical tunnel into a mine where minerals are extracted.
		MONITORING_STATION("monitoring_station"), // A station that monitors something.
		OBELISK("obelisk"),                 // Tall, narrow, four-sided, tapered monument which usually ends in a pyramid-like shape at the top.
		OBSERVATORY("observatory"),         // Observatory: a location used for observing terrestrial or celestial events
		OFFSHORE_PLATFORM("offshore_platform"), // Offshore platform, oil platform or offshore drilling rig
		PETROLEUM_WELL("petroleum_well"),   // A hole bored in the earth, designed to bring petroleum oil or gas to the surface
		PIER("pier"),                       // A pier is a raised walkway over water, supported by widely spread piles or pillars.
		PIPELINE("pipeline"),               // A major pipeline carrying gas, water, oil, etc.
		PUMP("pump"),                       // A device in charge of moving or raising the level of liquids.
		PUMPING_STATION("pumping_station"), // Pumping station: a facility including pumps and equipment for pumping fluids from one place to another
		RESERVOIR_COVERED("reservoir_covered"), // A covered reservoir is a large man-made tank for holding fresh water
		SILO("silo"),                       // A storage container for bulk material, often grains such as corn or wheat.
		SNOW_FENCE("snow_fence"),           // A fence-like structure built to redirect drifting snow
		SNOW_NET("snow_net"),               // A netting fence built across steep slopes to reduce risk and severity of (snow) avalanches
		STORAGE_TANK("storage_tank"),       // A container that holds liquids or compressed gases.
		STREET_CABINET("street_cabinet"),   // A cabinet located in the street and hosting technical equipment to operate facilities such as electricity or street lights.
		STUPA("stupa"),                     // A Buddhist dome-shaped structure with a spire on top
		SURVEILLANCE("surveillance"),       // A surveillance camera or other type of surveillance equipment.
		SURVEY_POINT("survey_point"),       // A triangulation pillar, geodetic vertex, or other piece of fixed equipment used by topographers.
		TAILINGS_POND("tailings_pond"),     // A body of liquid or slurry used to store byproducts of mining operations.
		TELESCOPE("telescope"),             // Telescope: an instrument that aids in the observation of remote objects by collecting light or radio waves
		TOWER("tower"),                     // A tower is a free-standing structure which is higher than it is wide.
		VIDEO_WALL("video_wall"),           // A digital screen, typically constructed out of smaller LED panels.
		WASTEWATER_PLANT("wastewater_plant"), // A wastewater plant is a facility used to treat wastewater.
		WATERMILL("watermill"),             // A mill driven by water power.
		WATER_TOWER("water_tower"),         // Structure with a water tank at an altitude to increase pressure in water network
		WATER_WELL("water_well"),           // A structural facility to access ground water, created by digging or drilling.
		WATER_TAP("water_tap"),             // Publicly usable water tap
		WATER_WORKS("water_works"),         // A facility where water is treated to make it suitable for human consumption.
		WILDLIFE_CROSSING("wildlife_crossing"), // Structure that allow animals to cross human barriers safely.
		WINDMILL("windmill"),               // A traditional windmill, historically used to mill grain with wind power.
		WORKS("works"),                     // A factory or industrial production plant
		YES("yes"),                         
	}
}