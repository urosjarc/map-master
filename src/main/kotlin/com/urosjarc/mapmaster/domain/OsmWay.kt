package com.urosjarc.mapmaster.domain

class OsmWay(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val nodes: MutableList<OsmNode> = mutableListOf(),
    val rels: MutableList<OsmRel> = mutableListOf(),
) : OsmObj(id = id, tags = tags) {
    fun connect(node: OsmNode) {
        //Way has connected nodes lineary
        this.nodes.lastOrNull()?.connect(node = node)
        this.nodes.add(node)
        node.parents.add(this)
    }
    override fun hashCode(): Int = this.id.hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as OsmObj
        return other.id == this.id
    }
}
