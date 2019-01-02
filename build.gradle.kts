import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.minecrell.pluginyml.nukkit.NukkitPluginDescription

plugins {
    kotlin("jvm") version "1.3.11"
    id("com.github.johnrengelman.shadow") version "4.0.3"
    id("net.minecrell.plugin-yml.nukkit") version "0.3.0"
}

group = "com.uramnoil.nukkit"
version = "1.0.2-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.nukkitx.com/main/")
    }
}

dependencies {
    implementation(kotlin("stdlib", "1.3.11"))
    compileOnly("cn.nukkit:nukkit:1.0-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.0")
}

nukkit {
    main = "com.uramnoil.nukkit.helloworld.HelloWorld"
    api = listOf("1.0.0")
    load = NukkitPluginDescription.PluginLoadOrder.POSTWORLD
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