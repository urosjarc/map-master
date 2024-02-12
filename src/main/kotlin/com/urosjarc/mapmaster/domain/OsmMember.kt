package com.urosjarc.mapmaster.domain

class OsmMember<T : OsmObj>(
    obj: T,
    objType: Type,
    val role: String?
) : OsmFeature(obj = obj, objType = objType) {
    override fun hashCode(): Int = this.obj.hashCode()
    override fun equals(other: Any?): Boolean = this.obj == other
}
