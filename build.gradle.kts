plugins {
    kotlin("jvm") version "2.0.20"
    id("com.gradleup.shadow") version "8.3.5"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "dev.tarna"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.3-R0.1-SNAPSHOT")
    implementation("com.github.DebitCardz:mc-chestui-plus:1.5.6")
    implementation("org.bstats:bstats-bukkit:3.0.2")
    implementation("org.reflections:reflections:0.10.2")
}

kotlin {
    jvmToolchain(21)
}

tasks {
    shadowJar {
        relocate("org.bstats", "dev.tarna.moretweaks.bstats")
    }

    runServer {
        minecraftVersion("1.21.3")
        jvmArgs("-DPaper.IgnoreJavaVersion=true", "-Dcom.mojang.eula.agree=true")
    }
}