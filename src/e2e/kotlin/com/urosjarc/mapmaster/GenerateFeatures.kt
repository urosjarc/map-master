package com.urosjarc.mapmaster

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

object GenerateFeatures {
    data class ClassEnumInfo(
        val key: String,
        val value: String,
        val desc: String
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val url = GenerateFeatures::class.java.getResource("/map-features.html") ?: throw Exception("Could not read resource!")
        val doc: Document = Jsoup.parse(File(url.path))
        val classes = mutableMapOf<String, MutableList<ClassEnumInfo>>()
        for (tr in doc.select("tr")) {
            val tds = tr.select("td")

            if (tds.size < 3) continue

            val ele = tds.subList(0, 2)

            val eInfo = ClassEnumInfo(
                key = ele[0].selectFirst("a")?.text() ?: continue,
                value = ele[1].selectFirst("a")?.text() ?: continue,
                desc = tds[3].text()
            )

            val failTests = listOf(
                eInfo.key.isBlank(),
                eInfo.value.isBlank(),
                eInfo.key == "source",
                eInfo.key.contains(":"),
                eInfo.value.contains(" "),
                eInfo.key.contains(" ")
            )

            if (failTests.contains(true)) continue

            val list = classes.getOrPut(key = eInfo.key) { mutableListOf() }

            list.firstOrNull { it.value == eInfo.value } ?: list.add(eInfo)
        }

        createFeatures(classes = classes)
        createOsmFeatures(classes = classes)
    }

    fun className(feature: String): String = feature
        .split("_")
        .map { it.replaceFirstChar(Char::uppercaseChar) }
        .joinToString("")

    fun createFeatures(classes: MutableMap<String, MutableList<ClassEnumInfo>>) {
        classes.forEach { feature, eInfos ->
            val className = className(feature = feature)
            val enums = mutableListOf<String>()

            eInfos.forEach {
                val enumName = it.value.uppercase()
                    .replace("-", "_")
                    .replace("9", "NINE_")
                    .replace("10", "TEN_")
                var enumDesc = it.desc.replace("\n", "")
                if (enumDesc.isNotBlank()) enumDesc = "// " + enumDesc
                enums.add("%-35s %s".format("$enumName(\"${it.value}\"),", enumDesc))
            }

            val text = "\t\t\t" + """package com.urosjarc.mapmaster.features
            import com.urosjarc.mapmaster.domain.* 
            
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

    private fun autoGenerate(name: String, content: String) = """// Autogenerate start: $name$content// Autogenerate end: $name"""

    fun createOsmFeatures(classes: MutableMap<String, MutableList<ClassEnumInfo>>) {

        val features = mutableListOf<String>()
        val add = mutableListOf<String>()

        classes.forEach { feature, u ->
            val className = className(feature = feature)
            features.add("val $feature = ${className}Features()")
            add.add(
                """
                if (tagKeys.contains("$feature")) {
                    this.all.getOrPut("$feature", ::mutableListOf).add(feature)
                    this.$feature.add(feature)
                    inserted = true;
                }
            """.trimIndent()
            )
        }

        val featuresText = features.joinToString("\n")
        val addText = add.joinToString("\n")

        val featuresRgx = Regex(autoGenerate(name = "features", content = "(.*)"), RegexOption.DOT_MATCHES_ALL)
        val addRgx = Regex(autoGenerate(name = "add", content = "(.*)"), RegexOption.DOT_MATCHES_ALL)

        File("src/main/kotlin/com/urosjarc/mapmaster/domain/OsmFeatures.kt").also {
            val text = it.readText()
                .replace(featuresRgx, autoGenerate(name = "features", content = "\n$featuresText\n"))
                .replace(addRgx, autoGenerate(name = "add", content = "\n$addText\n"))
            it.writeText(text)
        }
    }
}
