package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.features.*

/**
 * This file is auto generated!
 */


data class OsmMap(
    val minLat: Float,
    val minLon: Float,
    val maxLat: Float,
    val maxLon: Float
) {

    val aerialway = AerialwayFeatures()
    val aeroway = AerowayFeatures()
    val amenity = AmenityFeatures()
    val barrier = BarrierFeatures()
    val boundary = BoundaryFeatures()
    val building = BuildingFeatures()
    val entrance = EntranceFeatures()
    val craft = CraftFeatures()
    val emergency = EmergencyFeatures()
    val lifeguard = LifeguardFeatures()
    val geological = GeologicalFeatures()
    val highway = HighwayFeatures()
    val footway = FootwayFeatures()
    val cycleway = CyclewayFeatures()
    val busway = BuswayFeatures()
    val junction = JunctionFeatures()
    val service = ServiceFeatures()
    val historic = HistoricFeatures()
    val landuse = LanduseFeatures()
    val leisure = LeisureFeatures()
    val man_made = ManMadeFeatures()
    val military = MilitaryFeatures()
    val natural = NaturalFeatures()
    val office = OfficeFeatures()
    val place = PlaceFeatures()
    val power = PowerFeatures()
    val line = LineFeatures()
    val public_transport = PublicTransportFeatures()
    val railway = RailwayFeatures()
    val route = RouteFeatures()
    val shop = ShopFeatures()
    val sport = SportFeatures()
    val telecom = TelecomFeatures()
    val tourism = TourismFeatures()
    val water = WaterFeatures()
    val waterway = WaterwayFeatures()
    val hazard = HazardFeatures()
    val access = AccessFeatures()
    val maxaxleload = MaxaxleloadFeatures()
    val maxheight = MaxheightFeatures()
    val maxlength = MaxlengthFeatures()
    val maxspeed = MaxspeedFeatures()
    val maxweight = MaxweightFeatures()
    val maxwidth = MaxwidthFeatures()
    val minspeed = MinspeedFeatures()
    val traffic_sign = TrafficSignFeatures()

    fun add(feature: OsmFeature): Boolean {
        val tagKeys = feature.obj.tags.keys
        var inserted = false
        if (tagKeys.contains("aerialway")) {
            this.aerialway.add(feature); inserted = true
        }
        if (tagKeys.contains("aeroway")) {
            this.aeroway.add(feature); inserted = true
        }
        if (tagKeys.contains("amenity")) {
            this.amenity.add(feature); inserted = true
        }
        if (tagKeys.contains("barrier")) {
            this.barrier.add(feature); inserted = true
        }
        if (tagKeys.contains("boundary")) {
            this.boundary.add(feature); inserted = true
        }
        if (tagKeys.contains("building")) {
            this.building.add(feature); inserted = true
        }
        if (tagKeys.contains("entrance")) {
            this.entrance.add(feature); inserted = true
        }
        if (tagKeys.contains("craft")) {
            this.craft.add(feature); inserted = true
        }
        if (tagKeys.contains("emergency")) {
            this.emergency.add(feature); inserted = true
        }
        if (tagKeys.contains("lifeguard")) {
            this.lifeguard.add(feature); inserted = true
        }
        if (tagKeys.contains("geological")) {
            this.geological.add(feature); inserted = true
        }
        if (tagKeys.contains("highway")) {
            this.highway.add(feature); inserted = true
        }
        if (tagKeys.contains("footway")) {
            this.footway.add(feature); inserted = true
        }
        if (tagKeys.contains("cycleway")) {
            this.cycleway.add(feature); inserted = true
        }
        if (tagKeys.contains("busway")) {
            this.busway.add(feature); inserted = true
        }
        if (tagKeys.contains("junction")) {
            this.junction.add(feature); inserted = true
        }
        if (tagKeys.contains("service")) {
            this.service.add(feature); inserted = true
        }
        if (tagKeys.contains("historic")) {
            this.historic.add(feature); inserted = true
        }
        if (tagKeys.contains("landuse")) {
            this.landuse.add(feature); inserted = true
        }
        if (tagKeys.contains("leisure")) {
            this.leisure.add(feature); inserted = true
        }
        if (tagKeys.contains("man_made")) {
            this.man_made.add(feature); inserted = true
        }
        if (tagKeys.contains("military")) {
            this.military.add(feature); inserted = true
        }
        if (tagKeys.contains("natural")) {
            this.natural.add(feature); inserted = true
        }
        if (tagKeys.contains("office")) {
            this.office.add(feature); inserted = true
        }
        if (tagKeys.contains("place")) {
            this.place.add(feature); inserted = true
        }
        if (tagKeys.contains("power")) {
            this.power.add(feature); inserted = true
        }
        if (tagKeys.contains("line")) {
            this.line.add(feature); inserted = true
        }
        if (tagKeys.contains("public_transport")) {
            this.public_transport.add(feature); inserted = true
        }
        if (tagKeys.contains("railway")) {
            this.railway.add(feature); inserted = true
        }
        if (tagKeys.contains("route")) {
            this.route.add(feature); inserted = true
        }
        if (tagKeys.contains("shop")) {
            this.shop.add(feature); inserted = true
        }
        if (tagKeys.contains("sport")) {
            this.sport.add(feature); inserted = true
        }
        if (tagKeys.contains("telecom")) {
            this.telecom.add(feature); inserted = true
        }
        if (tagKeys.contains("tourism")) {
            this.tourism.add(feature); inserted = true
        }
        if (tagKeys.contains("water")) {
            this.water.add(feature); inserted = true
        }
        if (tagKeys.contains("waterway")) {
            this.waterway.add(feature); inserted = true
        }
        if (tagKeys.contains("hazard")) {
            this.hazard.add(feature); inserted = true
        }
        if (tagKeys.contains("access")) {
            this.access.add(feature); inserted = true
        }
        if (tagKeys.contains("maxaxleload")) {
            this.maxaxleload.add(feature); inserted = true
        }
        if (tagKeys.contains("maxheight")) {
            this.maxheight.add(feature); inserted = true
        }
        if (tagKeys.contains("maxlength")) {
            this.maxlength.add(feature); inserted = true
        }
        if (tagKeys.contains("maxspeed")) {
            this.maxspeed.add(feature); inserted = true
        }
        if (tagKeys.contains("maxweight")) {
            this.maxweight.add(feature); inserted = true
        }
        if (tagKeys.contains("maxwidth")) {
            this.maxwidth.add(feature); inserted = true
        }
        if (tagKeys.contains("minspeed")) {
            this.minspeed.add(feature); inserted = true
        }
        if (tagKeys.contains("traffic_sign")) {
            this.traffic_sign.add(feature); inserted = true
        }
        return inserted
    }
}
