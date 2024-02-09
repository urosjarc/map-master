package com.urosjarc.mapmaster.domain

sealed interface OsmFeature {
    val id: Long
    val tags: MutableMap<String, String>,
    val nodes: List<OsmNode>,
    val ways: List<OsmWay>
}
