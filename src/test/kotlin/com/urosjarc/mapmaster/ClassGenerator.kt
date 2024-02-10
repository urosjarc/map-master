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

        createFeatures(classes = classes)
        createOsmFeatures(classes = classes)
    }

    fun className(feature: String): String = feature
        .split("_")
        .map { it.replaceFirstChar(Char::uppercaseChar) }
        .joinToString("")

    fun createFeatures(classes: MutableMap<String, MutableSet<Pair<String, String>>>) {
        classes.forEach { feature, u ->
            val className = className(feature = feature)
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

            val text = "\t\t\t" + """package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.* 
            
            /**
             * This file is auto generated!
             */

            data class ${className}Node(
                val node: OsmNode,
                val type: ${className}Type
            )

            data class ${className}Way(
                val way: OsmWay,
                val type: ${className}Type
            )

            data class ${className}Rel(
                val rel: OsmRel,
                val type: ${className}Type
            )

            data class ${className}Features(
                val nodes: MutableList<${className}Node> = mutableListOf(),
                val ways: MutableList<${className}Way> = mutableListOf(),
                val rels: MutableList<${className}Rel> = mutableListOf()
            ) {
                fun add(feature: OsmFeature) {
                    val enumValue = feature.obj.tags["$feature"]
                    val type = ${className}Type.entries.firstOrNull { it.value == enumValue }
                        ?: ${className}Type.OTHER
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
                OTHER("other")
            }
            """.trimIndent()

            File("src/main/kotlin/com/urosjarc/mapmaster/features/$className.kt")
                .writeText(text)
        }
    }

    fun createOsmFeatures(classes: MutableMap<String, MutableSet<Pair<String, String>>>) {

        val attr = mutableListOf<String>()
        val ifs = mutableListOf<String>()

        classes.forEach { feature, u ->
            val className = className(feature = feature)
            attr.add("val $feature = ${className}Features()")
            ifs.add("""
                if (tagKeys.contains("$feature")) {
                    this.all.getOrPut("$feature") { mutableListOf() }.add(feature)
                    this.$feature.add(feature)
                    inserted = true;
                }
            """.trimIndent())
        }

        val text = "\t\t" + """
        package com.urosjarc.mapmaster
        
        import com.urosjarc.mapmaster.features.*
        
        /**
         * This file is auto generated!
         */
         
        class OsmFeatures {
            
            val all = mutableMapOf<String, MutableList<OsmFeature>>()

            ${attr.joinToString("\n\t\t\t")}

            fun add(feature: OsmFeature): Boolean {
                val tagKeys = feature.obj.tags.keys
                var inserted = false
                ${ifs.joinToString("\n\t\t\t\t")}
                return inserted
            }
        }
        """.trimIndent()

        File("src/main/kotlin/com/urosjarc/mapmaster/OsmFeatures.kt")
            .writeText(text)
    }
}
