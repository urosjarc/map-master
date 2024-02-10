package com.urosjarc.mapmaster.domain

class OsmWay(
    override val id: Long,
    override val tags: MutableMap<String, String>,
    val nodes: MutableList<OsmNode> = mutableListOf()
) : OsmObj
