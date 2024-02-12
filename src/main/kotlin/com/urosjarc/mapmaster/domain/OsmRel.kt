package com.urosjarc.mapmaster.domain

class OsmRel(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val nodes: MutableList<OsmMember<OsmNode>> = mutableListOf(),
    val ways: MutableList<OsmMember<OsmWay>> = mutableListOf(),
    val rels: MutableList<OsmMember<OsmRel>> = mutableListOf(),
) : OsmObj(id = id, tags = tags) {
    override fun hashCode(): Int = this.id.hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as OsmObj
        return other.id == this.id
    }
}
