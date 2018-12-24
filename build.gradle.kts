import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.3.10"
    id("com.github.johnrengelman.shadow") version "4.0.3"
}

group = "com.uramnoil.nukkit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.nukkitx.com/main/")
    }
}

dependencies {
    implementation(kotlin("stdlib", "1.3.11"))
    implementation("cn.nukkit:nukkit:1.0-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")
}

defaultTasks = listOf("shadowJar")

tasks {
    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    "shadowJar"(ShadowJar::class) {
        baseName = project.name
    }
}