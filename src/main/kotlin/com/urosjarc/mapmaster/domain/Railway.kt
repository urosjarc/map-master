package com.urosjarc.mapmaster.domain

data class Railway(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		ABANDONED("abandoned"),             // The course of a former railway which has been abandoned and the track removed. The course is still recognized through embankments, cuttings, tree rows, bridges, tunnels, remaining track ties, building shapes and rolling or straight ways. For demolished rails that are no longer identifiable, e.g. that have been built over, some use the highly questionable railway=razed.
		CONSTRUCTION("construction"),       // Railway under construction.
		DISUSED("disused"),                 // A section of railway which is no longer used but where the track and infrastructure remains in place. The track is likely overgrown with endemic vegetation, but could be brought back into useful service with only minor effort.
		FUNICULAR("funicular"),             // Cable driven inclined railways on a steep slope, with a pair of cars connected by one cable
		LIGHT_RAIL("light_rail"),           // A higher-standard tram system, normally in its own right-of-way. Often it connects towns and thus reaches a considerable length (tens of kilometres).
		MINIATURE("miniature"),             // Miniature railways are narrower than narrow gauge and carry passengers, frequently at an exact scale of "standard-sized" rail (for example "1/4 scale"). They can often be found in parks.
		MONORAIL("monorail"),               // A railway with only a single rail. A monorail can run above the rail like in Las Vegas and Disneyland or can suspend below the rail like the Wuppertal Schwebebahn (Germany).
		NARROW_GAUGE("narrow_gauge"),       // Narrow-gauge passenger or freight train tracks. Narrow gauge railways can have mainline railway service like the Rhaetian Railway in Switzerland or can be a small light industrial railway. Use gauge=* to specify the actual width of rails in mm.
		PRESERVED("preserved"),             // This is the old tag for historic trains. Use railway:preserved=yes for historical railway instead.
		RAIL("rail"),                       // Full sized passenger or freight train tracks in the standard gauge for the country or state.
		SUBWAY("subway"),                   // A city passenger rail service running mostly grade separated (see Wikipedia:rapid transit). Often a significant portion of the line or its system/network is underground.
		TRAM("tram"),                       // One or two carriage rail vehicle tracks, usually sharing motor road, sometimes called "street running" (Other languages).
		HALT("halt"),                       // A small station without switches
		PLATFORM("platform"),               // This is parallel to the rail line for showing where the actual platforms are. It is also to know where you can change platform and enter the station, so use footpaths to connect them. This is really useful for routing too. Use in addition to public_transport=platform.
		STATION("station"),                 // Railway passenger and/or cargo station. Use in addition to public_transport=station.
		SUBWAY_ENTRANCE("subway_entrance"), // The entrance to a subway station, usually going from surface to underground.
		TRAM_STOP("tram_stop"),             // A tram stop is a place where a passenger can embark / disembark a tram.
		BUFFER_STOP("buffer_stop"),         // Stops the train at the end of a track. See buffer stop.
		DERAIL("derail"),                   // A device used to prevent fouling of a rail track by unauthorized movements of trains or unattended rolling stock. See Derail (railroad).
		CROSSING("crossing"),               // A point where pedestrians may cross.
		LEVEL_CROSSING("level_crossing"),   // A point where rails and roads cross.
		TRAM_LEVEL_CROSSING("tram_level_crossing"), // A point where trams and roads cross.
		SIGNAL("signal"),                   // Any kind of railway signal.
		SWITCH("switch"),                   // Full connections between railways (aka 'points').
		RAILWAY_CROSSING("railway_crossing"), // Crossing rails with no interconnection.
		TURNTABLE("turntable"),             // These are used for changing the direction that part of a train is pointing in.
		ROUNDHOUSE("roundhouse"),           // A semicircular building with many stalls for servicing engines.
		TRAVERSER("traverser"),             // These are used for changing trains between railways. Also known as transfer table.
		WASH("wash"),                       // A railroad carriage/car wash
		WATER_CRANE("water_crane"),         // A structure to deliver water to steam locomotives
		VENTILATION_SHAFT("ventilation_shaft"), // A structure that allows ventilation in underground tunnels
	}
}