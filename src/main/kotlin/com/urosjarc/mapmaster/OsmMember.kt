package com.urosjarc.mapmaster

data class OsmMember<T : OsmObj>(
    val obj: T?,
    val role: String?
)
