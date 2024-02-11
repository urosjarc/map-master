package com.urosjarc.mapmaster.domain

data class OsmMember<T : OsmObj>(
    val obj: T?,
    val role: String?
)
