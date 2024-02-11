package com.urosjarc.mapmaster.domain

data class OsmNode(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val position: MapPosition,
    val elevation: Float?,
    val parents: MutableSet<OsmWay> = mutableSetOf()
) : OsmObj(id = id, tags = tags)
