package com.urosjarc.mapmaster.domain

abstract class OsmObj(
    open val id: Long,
    open val tags: MutableMap<String, String>
) {
    val street get(): String? = this.tags["addr:street"]
    val houseNumber get(): String? = this.tags["addr:housenumber"]
    val address get(): String? = if (this.houseNumber != null) "${this.street} ${this.houseNumber}" else this.street
}
