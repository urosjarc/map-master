package com.urosjarc.mapmaster

interface OsmObj {
    val id: Long
    val tags: MutableMap<String, String>
}
