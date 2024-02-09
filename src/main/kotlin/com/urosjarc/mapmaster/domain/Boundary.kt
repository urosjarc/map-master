package com.urosjarc.mapmaster.domain

data class Boundary(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		ABORIGINAL_LANDS("aboriginal_lands"), // A boundary representing official reservation boundaries of recognized aboriginal / indigenous / native peoples.
		ADMINISTRATIVE("administrative"),   // An administrative boundary. Subdivisions of areas/territories/jurisdictions recognised by governments or other organisations for administrative purposes. These range from large groups of nation states right down to small administrative districts and suburbs, as indicated by the 'admin_level=*' combo tag.
		BORDER_ZONE("border_zone"),         // A border zone is an area near the border where special restrictions on movement apply. Usually a permit is required for visiting.
		FOREST("forest"),                   // A delimited forest is a land which is predominantly wooded and which is, for this reason, given defined boundaries. It may cover different tree stands, non-wooded areas, highways… but all the area within the boundaries are considered and managed as a single forest.
		FOREST_COMPARTMENT("forest_compartment"), // A forest compartment is a numbered sub-division within a delimited forest, physically materialized with visible, typically cleared, boundaries.
		HAZARD("hazard"),                   // A designated hazardous area, with a potential source of damage to health, life, property, or any other interest of value.
		MARITIME("maritime"),               // Maritime boundaries which are not administrative boundaries: the Baseline, Contiguous Zone and EEZ (Exclusive Economic Zone).
		MARKER("marker"),                   // A boundary marker, border marker, boundary stone, or border stone is a robust physical marker that identifies the start of a land boundary or the change in a boundary, especially a change in direction of a boundary. See also historic=boundary_stone
		NATIONAL_PARK("national_park"),     // Area of outstanding natural beauty, set aside for conservation and for recreation (Other languages).
		PLACE("place"),                     // boundary=place is commonly used to map the boundaries of a place=*, when these boundaries can be defined but these are not administrative boundaries.
		POLITICAL("political"),             // Electoral boundaries
		POSTAL_CODE("postal_code"),         // Postal code boundaries
		PROTECTED_AREA("protected_area"),   // Protected areas, such as for national parks, marine protection areas, heritage sites, wilderness, cultural assets and similar.
		SPECIAL_ECONOMIC_ZONE("special_economic_zone"), // A government-defined area in which business and trade laws are different.
		DISPUTED("disputed"),               // An area of landed claimed by two or more parties (use with caution). See also Disputed territories.
	}
}