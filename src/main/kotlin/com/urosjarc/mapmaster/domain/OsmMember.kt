package com.urosjarc.mapmaster.domain

interface OsmMember<T : OsmObj> {
    val obj: T
    val role: String
}
