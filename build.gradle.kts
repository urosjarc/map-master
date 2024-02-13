import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
    kotlin("jvm") version "1.9.22"
    id("com.adarshr.test-logger") version "4.0.0"
    `jvm-test-suite`
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.urosjarc"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    this.implementation("me.xdrop:fuzzywuzzy:1.4.0")
    this.implementation("org.apache.logging.log4j:log4j-api-kotlin:1.4.0")

    val ktor_version = "2.3.8"
    this.testImplementation("org.jsoup:jsoup:1.17.2")
    this.testImplementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    this.testImplementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    this.testImplementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    this.testImplementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    this.testImplementation("io.ktor:ktor-server-cors:$ktor_version")
    this.testImplementation("org.jetbrains.kotlin:kotlin-test")
    this.testImplementation("org.apache.logging.log4j:log4j-core:2.20.0")
    this.testImplementation("org.apache.logging.log4j:log4j-slf4j-impl:2.20.0")
    this.testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.20.0")
}
tasks.withType<ShadowJar> {
    manifest {
        attributes(mapOf(
            "Main-Class" to "com.urosjarc.mapmaster.MapVisualizer"
        ))
    }
    archiveClassifier.set("test")
    from(sourceSets["test"].output)
    configurations = listOf(project.configurations.testRuntimeClasspath.get())
}

testlogger {
    this.setTheme("mocha")
}

kotlin {
    jvmToolchain(8)
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = rootProject.group as String
            artifactId = rootProject.name
            version = rootProject.version as String
            from(components["java"])

            pom {
                name = "Map master"
                description = "Kotlin lib. for handle OpenStreetMap objects"
                url = "https://github.com/urosjarc/map-master"
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "urosjarc"
                        name = "Uroš Jarc"
                        email = "jar.fmf@gmail.com"
                    }
                }
            }
        }
    }
}
