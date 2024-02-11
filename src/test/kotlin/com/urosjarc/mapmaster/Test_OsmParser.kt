package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.domain.*
import com.urosjarc.mapmaster.features.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Test_OsmParser {
    @Test
    fun `test full map`() {
        val url = Test_OsmParser::class.java.getResource("/Slovenija_Ljubljana_Trnovo.osm")!!
        val map = OsmParser.parse(url.path)
        assertEquals(expected = 46.0369400, actual = map.minLat)
        assertEquals(expected = 14.4979900, actual = map.minLon)
        assertEquals(expected = 46.0462700, actual = map.maxLat)
        assertEquals(expected = 14.5156100, actual = map.maxLon)
        val mapSize = map.features.all.map { it.key to it.value.size }.toMap()
        assertEquals(
            actual = mapSize,
            expected = mapOf(
                "highway" to 1817, "man_made" to 91, "place" to 10,
                "barrier" to 518, "amenity" to 512, "historic" to 17,
                "leisure" to 49, "tourism" to 38, "railway" to 6,
                "public_transport" to 35, "shop" to 21, "access" to 292,
                "office" to 14, "craft" to 3, "building" to 1229,
                "power" to 15, "entrance" to 40, "natural" to 1308,
                "emergency" to 8, "maxspeed" to 199, "sport" to 16,
                "maxheight" to 7, "cycleway" to 15, "waterway" to 13,
                "landuse" to 398, "maxweight" to 1, "service" to 248,
                "junction" to 4, "footway" to 196, "route" to 83,
                "water" to 10, "boundary" to 5,
            )
        )
    }


    @Test
    fun `test empty map`() {
        val url = Test_OsmParser::class.java.getResource("/empty_map.osm")!!
        val map = OsmParser.parse(url.path)
        assertEquals(expected = 46.0369400, actual = map.minLat)
        assertEquals(expected = 14.4979900, actual = map.minLon)
        assertEquals(expected = 46.0462700, actual = map.maxLat)
        assertEquals(expected = 14.5156100, actual = map.maxLon)

        val mapSize = map.features.all.map { it.key to it.value.size }.toMap()
        assertEquals(actual = mapSize, expected = mapOf())
    }

    @Test
    fun `test map with nodes`() {
        val url = Test_OsmParser::class.java.getResource("/map_with_nodes.osm")!!
        val map = OsmParser.parse(url.path)
        assertEquals(expected = 1.0, actual = map.minLat)
        assertEquals(expected = 2.0, actual = map.minLon)
        assertEquals(expected = 3.0, actual = map.maxLat)
        assertEquals(expected = 4.0, actual = map.maxLon)
        val mapSize = map.features.all.map { it.key to it.value.size }.toMap()
        assertEquals(actual = mapSize, expected = mapOf("highway" to 1))
        assertEquals(
            actual = map.features.highway.nodes, expected = listOf(
                HighwayNode(
                    node = OsmNode(
                        id = 2, tags = mutableMapOf(
                            "highway" to "traffic_signals",
                            "traffic_signals" to "traffic_lights",
                            "traffic_signals:direction" to "backward",
                        ),
                        position = MapPosition(lat = 20.0, lon = 21.0),
                    ),
                    type = HighwayType.TRAFFIC_SIGNALS
                )
            )
        )
    }

    @Test
    fun `test map with ways`() {
        val url = Test_OsmParser::class.java.getResource("/map_with_ways.osm")!!
        val map = OsmParser.parse(url.path)
        assertEquals(expected = 1.0, actual = map.minLat)
        assertEquals(expected = 2.0, actual = map.minLon)
        assertEquals(expected = 3.0, actual = map.maxLat)
        assertEquals(expected = 4.0, actual = map.maxLon)
        val mapSize = map.features.all.map { it.key to it.value.size }.toMap()
        assertEquals(actual = mapSize, expected = mapOf("highway" to 3, "maxspeed" to 1))
        assertEquals(actual = map.features.highway.nodes.size, expected = 1)
        assertEquals(actual = map.features.highway.ways.size, expected = 2)
        assertEquals(actual = map.features.maxspeed.ways.size, expected = 1)


        val feature = MaxspeedWay(
            type = MaxspeedType.OTHER,
            way = OsmWay(
                id = 4698189,
                tags = mutableMapOf(
                    "bicycle" to "use_sidepath",
                    "foot" to "use_sidepath",
                    "highway" to "primary",
                    "lanes" to "3",
                    "lit" to "yes",
                    "maxspeed" to "60",
                    "name" to "Barjanska cesta",
                    "oneway" to "yes",
                    "placement" to "left_of:2",
                    "shoulder" to "no",
                    "sidewalk" to "separate",
                    "smoothness" to "excellent",
                    "source:maxspeed" to "sign",
                    "surface" to "asphalt",
                    "turn:lanes" to "left|through|right"
                ),
                nodes = mutableListOf(
                    OsmNode(id = 1, position = MapPosition(lat = 10.0, lon = 11.0)),
                    OsmNode(
                        id = 2, tags = mutableMapOf(
                            "highway" to "traffic_signals",
                            "traffic_signals" to "traffic_lights",
                            "traffic_signals:direction" to "backward",
                        ),
                        position = MapPosition(lat = 20.0, lon = 21.0),
                    )
                )
            )
        )
        assertEquals(actual = map.features.maxspeed.ways, expected = mutableListOf(feature))
        assertTrue(actual = map.features.maxspeed.ways.contains(feature))
    }

    @Test
    fun `test map with rels`() {
        val url = Test_OsmParser::class.java.getResource("/map_with_rels.osm")!!
        val map = OsmParser.parse(url.path)
        assertEquals(expected = 1.0, actual = map.minLat)
        assertEquals(expected = 2.0, actual = map.minLon)
        assertEquals(expected = 3.0, actual = map.maxLat)
        assertEquals(expected = 4.0, actual = map.maxLon)
        val mapSize = map.features.all.map { it.key to it.value.size }.toMap()
        assertEquals(actual = mapSize, expected = mapOf("highway" to 2, "building" to 1))
        assertEquals(
            actual = map.features.building.rels,
            expected = mutableListOf(
                BuildingRel(
                    type = BuildingType.YES,
                    rel = OsmRel(
                        id = 4,
                        tags = mutableMapOf(
                            "addr:housename" to "Konjusnica",
                            "building" to "yes",
                            "type" to "multipolygon"
                        ),
                        nodes = mutableListOf(
                            OsmMember(obj = OsmNode(id = 1, position = MapPosition(lat = 10.0, lon = 11.0)), role = "inner")
                        ),
                        ways = mutableListOf(
                            OsmMember(
                                role = "outer",
                                obj = OsmWay(
                                    id = 3,
                                    tags = mutableMapOf(
                                        "highway" to "residential",
                                        "name" to "Mivka",
                                    ),
                                    nodes = mutableListOf(
                                        OsmNode(id = 1, position = MapPosition(lat = 10.0, lon = 11.0)),
                                        OsmNode(
                                            id = 2,
                                            position = MapPosition(
                                                lat = 20.0,
                                                lon = 21.0,
                                            ),
                                            tags = mutableMapOf(
                                                "highway" to "traffic_signals",
                                                "traffic_signals" to "traffic_lights",
                                                "traffic_signals:direction" to "backward",
                                            ),
                                        )
                                    )
                                ),
                            )
                        )
                    )
                )
            )
        )
    }
}
