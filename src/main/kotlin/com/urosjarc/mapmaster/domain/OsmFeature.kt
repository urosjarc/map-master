package com.urosjarc.mapmaster.domain

sealed interface OsmFeature {
    val id: Long
    val tags: Map<String, String>
    val nodes: List<OsmNode>
}
