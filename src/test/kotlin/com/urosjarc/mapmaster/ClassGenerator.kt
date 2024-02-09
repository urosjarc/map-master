package com.urosjarc.mapmaster

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

object TagsParser {
    @JvmStatic
    fun main(args: Array<String>) {
        val url = TagsParser::class.java.getResource("/map-features.html") ?: throw Exception("Could not read resource!")
        val doc: Document = Jsoup.parse(File(url.path))
        val classes = mutableMapOf<String, MutableSet<Pair<String, String>>>()
        for (tr in doc.select("tr")) {
            try {
                val tds = tr.select("td")
                val ele = tds.subList(0, 2)
                val key = ele[0].selectFirst("a")?.text() ?: throw Exception("Fail")
                val value = ele[1].selectFirst("a")?.text() ?: throw Exception("Fail")
                val desc = tds[3].text()

                if (key.isBlank() || value.isBlank() || key == "source" || key.contains(":") || value.contains(" ") || key.contains(" ")) continue
                val list = classes.getOrPut(key = key) { mutableSetOf() }
                list.firstOrNull { it.first == value } ?: list.add(value to desc)
            } catch (e: Exception) {
            }
        }

        val osmFile = mutableListOf<String>()
        osmFile.add("package com.urosjarc.mapmaster.domain")
        osmFile.add("class OsmMap(")
        osmFile.add("\tval minLat: Double,")
        osmFile.add("\tval minLon: Double,")
        osmFile.add("\tval maxLat: Double,")
        osmFile.add("\tval maxLon: Double")
        osmFile.add(") {\n")

        val osmFileFun = mutableListOf("")
        osmFileFun.add("\tfun addMapFeature(feature: OsmFeature){")
        osmFileFun.add("\t\twhen(feature){")

        classes.forEach { t, u ->
            val className = t.replaceFirstChar(Char::uppercaseChar)
            val file = mutableListOf<String>()
            osmFile.add("\tval ${className.lowercase()} = mutableListOf<$className>()")
            osmFileFun.add("\t\t\tis $className -> this.$t.add(feature)")
            file.add("package com.urosjarc.mapmaster.domain\n")
            file.add("data class $className(")
            file.add("\toverride val id: Long,")
            file.add("\toverride val nodes: List<OsmNode>,")
            file.add("\toverride val tags: Map<String, String>,")
            file.add("\tval type: Type")
            file.add("): OsmFeature {")
            file.add("\tenum class Type(val value: String) {")
            u.forEach {
                val enumName = it.first.uppercase()
                    .replace("-", "_")
                    .replace("9", "NINE_")
                    .replace("10", "TEN_")
                var enumDesc = it.second.replace("\n", "")
                if (enumDesc.isNotBlank()) enumDesc = "// " + enumDesc
                file.add("\t\t%-35s %s".format("$enumName(\"${it.first}\"),", enumDesc))
            }
            file.add("\t}")
            file.add("}")

            File("src/main/kotlin/com/urosjarc/mapmaster/domain/$className.kt").writeText(file.joinToString("\n"))
        }

        osmFileFun.add("\t\t}")
        osmFileFun.add("\t}")
        osmFile.addAll(osmFileFun)
        osmFile.add("}")

        File("src/main/kotlin/com/urosjarc/mapmaster/domain/OsmMap.kt").writeText(osmFile.joinToString("\n"))
    }
}
