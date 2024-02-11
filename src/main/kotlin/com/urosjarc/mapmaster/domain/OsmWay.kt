package com.urosjarc.mapmaster.domain

data class OsmWay(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val nodes: MutableList<OsmNode> = mutableListOf()
) : OsmObj(id = id, tags = tags)
