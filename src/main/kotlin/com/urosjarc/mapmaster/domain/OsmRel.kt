package com.urosjarc.mapmaster.domain

class OsmRel(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val nodes: MutableList<OsmNode> = mutableListOf(),
    val ways: MutableList<OsmWay> = mutableListOf(),
    val rels: MutableList<OsmRel> = mutableListOf()
): OsmFeature
