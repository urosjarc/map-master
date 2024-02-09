package com.urosjarc.mapmaster.domain

import com.urosjarc.mapmaster.domain.OsmFeature
import com.urosjarc.mapmaster.domain.OsmNode

class OsmWay(
    override val id: Long,
    override val tags: MutableMap<String, String> = mutableMapOf(),
    val nodes: MutableList<OsmNode> = mutableListOf()
) : OsmFeature
