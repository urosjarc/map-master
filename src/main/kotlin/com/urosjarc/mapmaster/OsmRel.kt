package com.urosjarc.mapmaster

data class OsmRel(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val nodes: MutableList<OsmMember<OsmNode>> = mutableListOf(),
    val ways: MutableList<OsmMember<OsmWay>> = mutableListOf(),
    val rels: MutableList<OsmMember<OsmRel>> = mutableListOf(),
) : OsmObj(id = id, tags = tags)
