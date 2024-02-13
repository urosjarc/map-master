package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.domain.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.slf4j.event.Level

class MapVisualizer {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val url = MapVisualizer::class.java.getResourceAsStream("/osm/Slovenija_Ljubljana_Trnovo.osm")!!
            val map = OsmParser.parse(url)

            val port = System.getenv("PORT")?.toInt() ?: 8080

            embeddedServer(Netty, port = port, host = "0.0.0.0") {
                install(ContentNegotiation) {
                    json(Json {
                        allowSpecialFloatingPointValues = true
                        prettyPrint = true
                        isLenient = true
                    })
                }
                install(CORS) {
                    this.allowHeader(HttpHeaders.ContentType)
                    this.allowHeader(HttpHeaders.Authorization)
                    this.anyHost()
                    this.allowMethod(HttpMethod.Post)
                    this.allowMethod(HttpMethod.Put)
                    this.allowMethod(HttpMethod.Get)
                    this.allowMethod(HttpMethod.Delete)
                }
                this.install(CallLogging) {
                    this.level = Level.DEBUG
                    format { call ->
                        val status = call.response.status()
                        val httpMethod = call.request.httpMethod.value
                        val userAgent = call.request.headers["User-Agent"]
                        "Status: $status, HTTP method: $httpMethod, User agent: $userAgent"
                    }
                }

                routing {
                    staticResources("/", "app") {
                        default("index.html")
                    }

                    get("/lines") {
                        val ways = map.getTransitWays(vehicle = OsmVehicle.BODY, suitability = OsmSuitability.CATASTROFIC)
                        val matrix = mutableListOf<MutableList<Map<String, Double>>>()
                        ways.forEach { way ->
                            val coordinates = mutableListOf<Map<String, Double>>()
                            way.nodes.forEach { node -> coordinates.add(node.position.toMap()) }
                            matrix.add(coordinates)
                        }
                        call.respond(matrix)
                    }
                    get("/streets") {
                        val query = this.call.request.queryParameters["query"]!!
                        val streets: List<MapMatch> = map.searchStreet(query = query)
                        call.respond(streets.map { it.match }.toList())
                    }
                    get("/street") {
                        val name = this.call.request.queryParameters["name"]!!
                        val features = map.getStreetFeatures(name = name)
                        val ele = features!!.first().obj
                        call.respond(ele.position.toMap())
                    }
                    get("/closestStreet") {
                        val match: MapMatch = map.searchClosestStreets(
                            position = MapVector(
                                lat = this.call.request.queryParameters["lat"]!!.toDouble(),
                                lon = this.call.request.queryParameters["lon"]!!.toDouble()
                            ),
                            radius = 1000f
                        ).first()
                        call.respond(
                            JsonObject(
                                mapOf(
                                    "match" to JsonPrimitive(match.match),
                                    "distance" to JsonPrimitive(match.distance),
                                )
                            )
                        )
                    }
                    get("/route") {
                        val start = this.call.request.queryParameters["start"]!!
                        val end = this.call.request.queryParameters["end"]!!
                        val startPos = map.getStreetFeatures(name = start)!!.first().obj.position
                        val endPos = map.getStreetFeatures(name = end)!!.first().obj.position
                        val routeNodes: List<OsmRouteNode> = map.searchShortestTransitWay(
                            start = startPos,
                            finish = endPos,
                            vehicle = OsmVehicle.BODY,
                            suitability = OsmSuitability.CATASTROFIC
                        )

                        val routeNodeJson = routeNodes.map {
                            JsonObject(
                                mapOf(
                                    "turnAngle" to JsonPrimitive(it.turnAngle),
                                    "address" to JsonPrimitive(it.address),
                                    "lat" to JsonPrimitive(it.vector.lat),
                                    "lon" to JsonPrimitive(it.vector.lon),
                                    "description" to JsonPrimitive(it.description),
                                )
                            )
                        }

                        call.respond(JsonArray(routeNodeJson))
                    }
                }
            }.start(wait = true)
        }
    }
}
