
rootProject.name = "helsearbeidsgiver-bigquery"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val kotlinterVersion: String by settings

        kotlin("jvm") version kotlinVersion
        id("org.jmailen.kotlinter") version kotlinterVersion
    }
}