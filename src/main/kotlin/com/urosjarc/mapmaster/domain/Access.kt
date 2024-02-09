package com.urosjarc.mapmaster.domain

data class Access(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		DESIGNATED("designated"),           // General access permission. agricultural – Only for agricultural traffic delivery – Only when delivering to the element. designated – A preferred or designated route for a specific vehicle type or types. Not compulsory but often marked by a traffic sign destination – Used for ways in designated local traffic areas, where traffic should only enter if its destination is within the area forestry – Only for forestry traffic no – No access for the general public. Consider using another tag indicating who can use the element official – The way is dedicated to a specific mode of travel by law. Usually marked by traffic signs and exclusive. In Germany use is also compulsory. clarification needed permissive – Open to general traffic until such time as the owner revokes the permission which they are legally allowed to do at any time in the future. private – Only with permission of the owner on an individual basis yes – The public has an official, legal right of access, i.e. it's a right of way (default value)
	}
}