package com.urosjarc.mapmaster.domain

abstract class OsmObj(
    open val id: Long,
    open val tags: MutableMap<String, String>,
) {
    abstract val position: MapVector
    val street get(): String? = this.tags["addr:street"]
    val houseNumber get(): String? = this.tags["addr:housenumber"]
    val address get(): String? = if (this.houseNumber != null) "${this.street} ${this.houseNumber}" else this.street

    fun connect(member: OsmMember<*>) {
        when (member.objType) {
            OsmFeature.Type.NODE -> TODO()
            OsmFeature.Type.RELATIONSHIP -> TODO()
            OsmFeature.Type.WAY -> TODO()
        }
    }

    override fun hashCode(): Int = this.id.hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as OsmObj
        return other.id == this.id
    }
}
