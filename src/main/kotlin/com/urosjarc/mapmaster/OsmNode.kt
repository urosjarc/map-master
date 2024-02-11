package com.urosjarc.mapmaster

data class OsmNode(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val position: OsmPosition,
    val parents: MutableSet<OsmWay> = mutableSetOf()
) : OsmObj(id = id, tags = tags)
