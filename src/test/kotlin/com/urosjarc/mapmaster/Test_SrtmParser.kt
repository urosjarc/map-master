package com.urosjarc.mapmaster

import com.urosjarc.mapmaster.domain.MapVector
import org.junit.jupiter.api.Test

class Test_SrtmParser {
    @Test
    fun `test full map`() {
        val url = Test_SrtmParser::class.java.getResource("/N46E014.hgt")!!
        val srtmMap = SrtmParser.parse(path = url.path, lat = 46, lon = 14)
        val ele = srtmMap.elevation(position = MapVector(lat = 46.3021667, lon = 14.6336574))
        println(ele)
    }

}
