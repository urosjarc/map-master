package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.domain.MapMatch
import com.urosjarc.mapmaster.domain.OsmSuitability
import com.urosjarc.mapmaster.domain.OsmVehicle
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json


fun main() {
    val url = Test_OsmParser::class.java.getResource("/osm/Slovenija_Ljubljana_Trnovo.osm")!!
    val map = OsmParser.parse(url.path)

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json(Json {
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

        routing {
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
        }
    }.start(wait = true)
}
