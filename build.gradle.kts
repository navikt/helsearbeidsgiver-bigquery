import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "no.nav.helsearbeidsgiver"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://jitpack.io")
    mavenCentral()
    maven {
        credentials {
            username = System.getenv("GITHUB_ACTOR") ?: "x-access-token"
            password = System.getenv("GITHUB_TOKEN")
        }
        setUrl("https://maven.pkg.github.com/navikt/*")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.cloud:google-cloud-bigquery:2.13.8")
    implementation("com.github.navikt:rapids-and-rivers:2022061809451655538329.d6deccc62862") {
        exclude(group = "ch.qos.logback")
    }
    runtimeOnly("ch.qos.logback:logback-classic:1.2.11")
    implementation("org.slf4j:slf4j-api:1.7.30")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("no.nav.helsearbeidsgiver.bigquery.AppKt")
}
