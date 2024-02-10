package com.urosjarc.mapmaster.domain

interface OsmObj {
    val id: Long
    val tags: MutableMap<String, String>
}
