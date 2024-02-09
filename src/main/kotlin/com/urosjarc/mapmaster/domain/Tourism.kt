package com.urosjarc.mapmaster.domain

data class Tourism(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		ALPINE_HUT("alpine_hut"),           // A remote building located in the mountains intended to provide board and lodging.
		APARTMENT("apartment"),             // A furnished apartment or flat with cooking and bathroom facilities that can be rented for holiday vacations.
		AQUARIUM("aquarium"),               // A facility with living aquatic animals for public viewing.
		ARTWORK("artwork"),                 // A public piece of art.
		ATTRACTION("attraction"),           // An object of interest for a tourist, or a purpose-built tourist attraction
		CAMP_PITCH("camp_pitch"),           // A tent or caravan pitch location within a campsite or caravan site
		CAMP_SITE("camp_site"),             // An area where people can camp overnight using tents, camper vans, or caravans.
		CARAVAN_SITE("caravan_site"),       // A place where you can stay in a caravan overnight or for longer periods.
		CHALET("chalet"),                   // A holiday cottage with self-contained cooking and bathroom facilities.
		GALLERY("gallery"),                 // An area or building that displays a variety of visual art exhibitions.
		GUEST_HOUSE("guest_house"),         // Accommodation smaller than a hotel and typically owner-operated, such as bed&breakfasts etc.
		HOSTEL("hostel"),                   // Cheap accommodation with shared bedrooms.
		HOTEL("hotel"),                     // Hotel – an establishment that provides paid lodging
		INFORMATION("information"),         // Information for tourists and visitors, including information offices
		MOTEL("motel"),                     // Short term accommodation, particularly for people travelling by car.
		MUSEUM("museum"),                   // A museum: an institution with exhibitions on scientific, historical, cultural topics
		PICNIC_SITE("picnic_site"),         // A locality that is suitable for outdoors eating, with facilities to aid a picnic such as tables and benches
		THEME_PARK("theme_park"),           // An amusement park where entertainment is provided by rides, games, concessions.
		VIEWPOINT("viewpoint"),             // A place worth visiting, often high, with a good view of surrounding countryside or notable buildings.
		WILDERNESS_HUT("wilderness_hut"),   // A remote building, with generally a fireplace, intended to provide temporary shelter and sleeping accommodation, typically un-serviced and with no staff.
		ZOO("zoo"),                         // A zoological garden, where animals are confined for viewing by the public.
		YES("yes"),                         // A general tourist attraction.
	}
}