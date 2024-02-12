package com.urosjarc.mapmaster

import SrtmParser
import com.urosjarc.mapmaster.domain.MapPosition
import kotlin.test.Test

class Test_SrtmParser {
    @Test
    fun `test full map`() {
        val url = Test_SrtmParser::class.java.getResource("/N46E014.hgt")!!
        val srtmMap = SrtmParser.parse(path = url.path, lat = 46, lon = 14)
        val ele = srtmMap.elevation(position = MapPosition(lat = 46.3021667, lon = 14.6336574))
        println(ele)
    }

}