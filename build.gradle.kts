plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.shadow)
    alias(libs.plugins.paperweight)
    alias(libs.plugins.runpaper)
}

group = "dev.tarna"
version = "1.2.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public")
}

dependencies {
    paperweight.paperDevBundle(libs.versions.paper)
    implementation(libs.mcchestuiplus)
    implementation(libs.bstats)
    implementation(libs.reflections)
}

kotlin {
    jvmToolchain(21)
}

tasks {
    processResources {
        val props = mapOf("version" to version)
        inputs.properties(props)
        filteringCharset = "UTF-8"
        filesMatching("paper-plugin.yml") {
            expand(props)
        }
    }

    shadowJar {
        archiveBaseName.set("MoreTweaks")
        archiveClassifier.set("")
        relocate("org.bstats", "dev.tarna.moretweaks.bstats")
    }

    runServer {
        minecraftVersion("1.21.4")
        jvmArgs("-DPaper.IgnoreJavaVersion=true", "-Dcom.mojang.eula.agree=true")
    }
}

apply(from = "buildSrc/src/main/kotlin/createTweak.gradle.kts")