package com.urosjarc.mapmaster.domain

class OsmRel(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val nodes: MutableList<OsmMember<OsmNode>> = mutableListOf(),
    val ways: MutableList<OsmMember<OsmWay>> = mutableListOf(),
    val rels: MutableList<OsmMember<OsmRel>> = mutableListOf(),
) : OsmObj(id = id, tags = tags) {
    override val position
        get(): MapVector {
            val center = MapVector(lat = 0.0, lon = 0.0)

            (this.nodes + this.ways).forEach {
                center.lat += it.obj.position.lat
                center.lon += it.obj.position.lon
            }

            center.lat /= this.nodes.size
            center.lon /= this.nodes.size
            return center
        }

    override fun hashCode(): Int = this.id.hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as OsmObj
        return other.id == this.id
    }
}
