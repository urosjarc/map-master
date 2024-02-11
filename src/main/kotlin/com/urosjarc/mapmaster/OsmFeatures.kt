package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.features.*

/**
 * This file is auto generated!
 */

class OsmFeatures {

    val all = mutableMapOf<String, MutableList<OsmFeature>>()

    // Autogenerate start: features
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
    // Autogenerate end: features

    fun add(feature: OsmFeature): Boolean {
        val tagKeys = feature.obj.tags.keys
        var inserted = false
        // Autogenerate start: add
        if (tagKeys.contains("aerialway")) {
            this.all.getOrPut("aerialway", ::mutableListOf).add(feature)
            this.aerialway.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("aeroway")) {
            this.all.getOrPut("aeroway", ::mutableListOf).add(feature)
            this.aeroway.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("amenity")) {
            this.all.getOrPut("amenity", ::mutableListOf).add(feature)
            this.amenity.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("barrier")) {
            this.all.getOrPut("barrier", ::mutableListOf).add(feature)
            this.barrier.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("boundary")) {
            this.all.getOrPut("boundary", ::mutableListOf).add(feature)
            this.boundary.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("building")) {
            this.all.getOrPut("building", ::mutableListOf).add(feature)
            this.building.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("entrance")) {
            this.all.getOrPut("entrance", ::mutableListOf).add(feature)
            this.entrance.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("craft")) {
            this.all.getOrPut("craft", ::mutableListOf).add(feature)
            this.craft.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("emergency")) {
            this.all.getOrPut("emergency", ::mutableListOf).add(feature)
            this.emergency.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("lifeguard")) {
            this.all.getOrPut("lifeguard", ::mutableListOf).add(feature)
            this.lifeguard.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("geological")) {
            this.all.getOrPut("geological", ::mutableListOf).add(feature)
            this.geological.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("highway")) {
            this.all.getOrPut("highway", ::mutableListOf).add(feature)
            this.highway.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("footway")) {
            this.all.getOrPut("footway", ::mutableListOf).add(feature)
            this.footway.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("cycleway")) {
            this.all.getOrPut("cycleway", ::mutableListOf).add(feature)
            this.cycleway.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("busway")) {
            this.all.getOrPut("busway", ::mutableListOf).add(feature)
            this.busway.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("junction")) {
            this.all.getOrPut("junction", ::mutableListOf).add(feature)
            this.junction.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("service")) {
            this.all.getOrPut("service", ::mutableListOf).add(feature)
            this.service.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("historic")) {
            this.all.getOrPut("historic", ::mutableListOf).add(feature)
            this.historic.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("landuse")) {
            this.all.getOrPut("landuse", ::mutableListOf).add(feature)
            this.landuse.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("leisure")) {
            this.all.getOrPut("leisure", ::mutableListOf).add(feature)
            this.leisure.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("man_made")) {
            this.all.getOrPut("man_made", ::mutableListOf).add(feature)
            this.man_made.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("military")) {
            this.all.getOrPut("military", ::mutableListOf).add(feature)
            this.military.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("natural")) {
            this.all.getOrPut("natural", ::mutableListOf).add(feature)
            this.natural.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("office")) {
            this.all.getOrPut("office", ::mutableListOf).add(feature)
            this.office.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("place")) {
            this.all.getOrPut("place", ::mutableListOf).add(feature)
            this.place.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("power")) {
            this.all.getOrPut("power", ::mutableListOf).add(feature)
            this.power.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("line")) {
            this.all.getOrPut("line", ::mutableListOf).add(feature)
            this.line.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("public_transport")) {
            this.all.getOrPut("public_transport", ::mutableListOf).add(feature)
            this.public_transport.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("railway")) {
            this.all.getOrPut("railway", ::mutableListOf).add(feature)
            this.railway.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("route")) {
            this.all.getOrPut("route", ::mutableListOf).add(feature)
            this.route.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("shop")) {
            this.all.getOrPut("shop", ::mutableListOf).add(feature)
            this.shop.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("sport")) {
            this.all.getOrPut("sport", ::mutableListOf).add(feature)
            this.sport.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("telecom")) {
            this.all.getOrPut("telecom", ::mutableListOf).add(feature)
            this.telecom.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("tourism")) {
            this.all.getOrPut("tourism", ::mutableListOf).add(feature)
            this.tourism.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("water")) {
            this.all.getOrPut("water", ::mutableListOf).add(feature)
            this.water.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("waterway")) {
            this.all.getOrPut("waterway", ::mutableListOf).add(feature)
            this.waterway.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("hazard")) {
            this.all.getOrPut("hazard", ::mutableListOf).add(feature)
            this.hazard.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("access")) {
            this.all.getOrPut("access", ::mutableListOf).add(feature)
            this.access.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("maxaxleload")) {
            this.all.getOrPut("maxaxleload", ::mutableListOf).add(feature)
            this.maxaxleload.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("maxheight")) {
            this.all.getOrPut("maxheight", ::mutableListOf).add(feature)
            this.maxheight.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("maxlength")) {
            this.all.getOrPut("maxlength", ::mutableListOf).add(feature)
            this.maxlength.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("maxspeed")) {
            this.all.getOrPut("maxspeed", ::mutableListOf).add(feature)
            this.maxspeed.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("maxweight")) {
            this.all.getOrPut("maxweight", ::mutableListOf).add(feature)
            this.maxweight.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("maxwidth")) {
            this.all.getOrPut("maxwidth", ::mutableListOf).add(feature)
            this.maxwidth.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("minspeed")) {
            this.all.getOrPut("minspeed", ::mutableListOf).add(feature)
            this.minspeed.add(feature)
            inserted = true;
        }
        if (tagKeys.contains("traffic_sign")) {
            this.all.getOrPut("traffic_sign", ::mutableListOf).add(feature)
            this.traffic_sign.add(feature)
            inserted = true;
        }
        // Autogenerate end: add
        return inserted
    }
}
