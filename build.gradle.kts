plugins {
    `java-library`
    kotlin("jvm") version "1.9.22"
    id("com.adarshr.test-logger") version "4.0.0"
    `jvm-test-suite`
    `maven-publish`
}

group = "com.urosjarc"
version = "0.0.1-SNAPSHOT"

repositories {
    maven {
        setUrl("http://mvn.topobyte.de")
        isAllowInsecureProtocol = true
    }
    maven {
        setUrl("http://mvn.slimjars.com")
        isAllowInsecureProtocol = true
    }
    mavenCentral()
}

dependencies {
    val version = "0.3.1"
    this.implementation("org.jsoup:jsoup:1.17.2")


    this.implementation("de.topobyte:osm4j-xml:1.3.0")
    this.implementation("de.topobyte:osm4j-pbf:1.3.0")
    this.implementation("de.topobyte:osm4j-tbo:1.3.0")
    this.implementation("de.topobyte:osm4j-geometry:1.3.0")

    this.implementation("org.apache.logging.log4j:log4j-api-kotlin:1.4.0")
}

testing {
    suites {
        configureEach {
            if (this is JvmTestSuite) {
                useJUnitJupiter()
                dependencies {
                    this.implementation("org.jetbrains.kotlin:kotlin-test")
                    this.implementation("org.apache.logging.log4j:log4j-core:2.17.1")
                    this.implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.20.0")
                    this.implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.20.0")
                }
            }
        }

        register<JvmTestSuite>("e2e") {
            dependencies {
                this.implementation(project())
            }
        }
    }
}

testlogger {
    this.setTheme("mocha")
}

kotlin {
    jvmToolchain(19)
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
