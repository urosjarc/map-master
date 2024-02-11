package com.urosjarc.mapmaster

abstract class OsmObj(
    open val id: Long,
    open val tags: MutableMap<String, String>
) {
    fun street(): String? = this.tags["addr:street"]
    fun houseNumber(): String? = this.tags["addr:housenumber"]
}
