package com.urosjarc.mapmaster.domain

data class Route(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		BICYCLE("bicycle"),                 // Cycle routes or bicycles route are named, numbered or otherwise signed. May go along roads, trails or dedicated cycle paths
		BUS("bus"),                         // The route a public bus service takes. See Buses.
		CANOE("canoe"),                     // Signed route for canoeing through a waterway.
		DETOUR("detour"),                   // Route for fixed detour routes. Examples are Bedarfsumleitung in Germany and uitwijkroute in the Netherlands
		FERRY("ferry"),                     // The route a ferry takes from terminal to terminal Please make sure to add at least one node per tile (zoom level 12), better at least one every few km, so offline editors catch it with bbox requests.
		FOOT("foot"),                       // Walking Route - is used for routes which are walkable without any limitations regarding fitness, equipment or weather conditions.
		HIKING("hiking"),                   // Hiking explains how to tag hiking routes.
		HORSE("horse"),                     // Riding routes
		INLINE_SKATES("inline_skates"),     // Inline has more information on the subject.
		LIGHT_RAIL("light_rail"),           // Route of a light rail line.
		MTB("mtb"),                         // Mountain biking explains how to tag mtb routes.
		PISTE("piste"),                     // Route of a piste (e.g., snowshoe or XC-Ski trails) in a winter sport area.
		RAILWAY("railway"),                 // A sequence of railway ways, often named (e.g., Channel Tunnel). See Railways.
		ROAD("road"),                       // Can be used to map various road routes/long roads.
		RUNNING("running"),                 // For running (jogging) routes.
		SKI("ski"),                         // For ski tracks (e.g., XC-Ski Trails User:Langläufer/Loipemap).
		SUBWAY("subway"),                   // Route of a metro service
		TRAIN("train"),                     // Train services (e.g., London-Paris Eurostar) See Railways.
		TRACKS("tracks"),                   // Railroad track as rail infrastructure.
		TRAM("tram"),                       // See Trams for more information on tagging tram services.
		TROLLEYBUS("trolleybus"),           // The route of a trolleybus service.
	}
}