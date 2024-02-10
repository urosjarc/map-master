package com.urosjarc.mapmaster

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

object ClassGenerator {
    @JvmStatic
    fun main(args: Array<String>) {
        val url = ClassGenerator::class.java.getResource("/map-features.html") ?: throw Exception("Could not read resource!")
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

        this.createFeatures(classes = classes)
        this.createOsmMap(classes = classes)
    }

    fun className(feature: String): String = feature
        .split("_")
        .map { it.replaceFirstChar(Char::uppercaseChar) }
        .joinToString("")

    fun createFeatures(classes: MutableMap<String, MutableSet<Pair<String, String>>>) {
        classes.forEach { feature, u ->
            val className = this.className(feature = feature)
            val enums = mutableListOf<String>()

            u.forEach {
                val enumName = it.first.uppercase()
                    .replace("-", "_")
                    .replace("9", "NINE_")
                    .replace("10", "TEN_")
                var enumDesc = it.second.replace("\n", "")
                if (enumDesc.isNotBlank()) enumDesc = "// " + enumDesc
                enums.add("%-35s %s".format("$enumName(\"${it.first}\"),", enumDesc))
            }

            val text = "\t\t\t" + """package com.urosjarc.mapmaster.domain
            
            /**
             * This file is auto generated!
             */

            class ${className}Node(
                val node: OsmNode,
                val type: ${className}Type
            )

            class ${className}Way(
                val way: OsmWay,
                val type: ${className}Type
            )

            class ${className}Rel(
                val rel: OsmRel,
                val type: ${className}Type
            )

            class ${className}Features(
                val nodes: MutableList<${className}Node> = mutableListOf(),
                val ways: MutableList<${className}Way> = mutableListOf(),
                val rels: MutableList<${className}Rel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val type = ${className}Type.valueOf(feature.obj.tags["$feature"]!!)
                    when (feature.objType) {

                        OsmFeature.Type.NODE ->
                            this.nodes.add(${className}Node(node = feature.obj as OsmNode, type = type))

                        OsmFeature.Type.RELATIONSHIP ->
                            this.rels.add(${className}Rel(rel = feature.obj as OsmRel, type = type))

                        OsmFeature.Type.WAY ->
                            this.ways.add(${className}Way(way = feature.obj as OsmWay, type = type))

                    }
                }
            }

            enum class ${className}Type(val value: String) {
                ${enums.joinToString("\n\t\t\t\t")}
            }
            """.trimIndent()

            File("src/main/kotlin/com/urosjarc/mapmaster/domain/$className.kt")
                .writeText(text)
        }
    }


    fun createOsmMap(classes: MutableMap<String, MutableSet<Pair<String, String>>>) {

        val attr = mutableListOf<String>()
        val ifs = mutableListOf<String>()

        classes.forEach { feature, u ->
            val className = this.className(feature = feature)
            attr.add("val $feature = ${className}Features()")
            ifs.add("""if (tagKeys.contains("$feature")) this.$feature.add(feature)""")
        }

        val text = "\t\t" + """
        package com.urosjarc.mapmaster.domain
        
        /**
         * This file is auto generated!
         */

        class OsmMap(
            val minLat: Float,
            val minLon: Float,
            val maxLat: Float,
            val maxLon: Float
        ) {

            ${attr.joinToString("\n\t\t\t")}

            fun add(feature: OsmFeature) {
                val tagKeys = feature.obj.tags.keys
                ${ifs.joinToString("\n\t\t\t\t")}
                else throw Exception(feature.toString())
            }
        }
        """.trimIndent()

        File("src/main/kotlin/com/urosjarc/mapmaster/domain/OsmMap.kt")
            .writeText(text)
    }

}
