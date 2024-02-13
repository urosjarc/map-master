package com.urosjarc.mapmaster.domain

class OsmWay(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val nodes: MutableList<OsmNode> = mutableListOf(),
    val rels: MutableList<OsmRel> = mutableListOf(),
) : OsmObj(id = id, tags = tags) {

    override val position
        get(): MapVector {
            val center = MapVector(lat = 0.0, lon = 0.0)
            this.nodes.forEach {
                center.lat += it.position.lat
                center.lon += it.position.lon
            }
            center.lat /= this.nodes.size
            center.lon /= this.nodes.size
            return center
        }

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
