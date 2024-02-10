package com.urosjarc.mapmaster.domain

class OsmRel(
    override val id: Long,
    override val tags: MutableMap<String, String>,
    val nodes: MutableList<OsmMember<OsmNode>> = mutableListOf(),
    val ways: MutableList<OsmMember<OsmWay>> = mutableListOf(),
    val rels: MutableList<OsmMember<OsmRel>> = mutableListOf(),
) : OsmObj
