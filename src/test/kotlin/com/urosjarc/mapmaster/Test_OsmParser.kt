package com.urosjarc.mapmaster

import kotlin.io.path.Path
import kotlin.test.Test

class Test_OsmParser {
    @Test
    fun `test_parse(path)`() {
        val url = Test_OsmParser::class.java.getResource("/Slovenija_Ljubljana_Trnovo.osm") ?: throw Exception("Could not read resource!")
//        val map = OsmParser.parse(Path(url.path))
    }
}
