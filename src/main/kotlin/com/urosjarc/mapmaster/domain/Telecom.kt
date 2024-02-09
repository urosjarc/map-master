package com.urosjarc.mapmaster.domain

data class Telecom(
	override val id: Long,
	override val nodes: List<OsmNode>,
	override val tags: Map<String, String>,
	val type: Type
): OsmFeature {
	enum class Type(val value: String) {
		EXCHANGE("exchange"),               // A place to connect landlines subscribers to telecommunication service equipments
		CONNECTION_POINT("connection_point"), // Last point of telecom local loops allowing direct connections towards a few households and subscribers
		DISTRIBUTION_POINT("distribution_point"), // Equipment, often small boxes, allowing to directly connect up to 15 individuals or households to a single upstream local loop cable towards telecom exchanges
		SERVICE_DEVICE("service_device"),   // Active equipment which deliver service to connected customers. It can be for instance a DSLAM, a telephone switch, or more recently an OLT for optical networks. It excludes amplifiers or repeaters installed along local loops or long distance lines.
		DATA_CENTER("data_center"),         // A building used to house computers and network equipment.
		LINE("line"),                       // A telecommunication line.
	}
}