package com.urosjarc.mapmaster.domain

class OsmNode(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    override val position: MapVector,
    val elevation: Float? = null,
    val parents: MutableSet<OsmWay> = mutableSetOf(),
    val siblings: MutableSet<OsmNode> = mutableSetOf(),
    val rels: MutableList<OsmRel> = mutableListOf(),
) : OsmObj(id = id, tags = tags) {
    fun connect(node: OsmNode) {
        this.siblings.add(node)
        node.siblings.add(this)
    }

    override fun toString(): String {
        return "Node(id=$id)"
    }

    override fun hashCode(): Int = this.id.hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as OsmObj
        return other.id == this.id
    }
}
