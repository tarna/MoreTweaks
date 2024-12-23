package dev.tarna.moretweaks.api.config

import dev.tarna.moretweaks.MoreTweaks
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object ConfigUtils {
    private val plugin = MoreTweaks.getPlugin()

    fun createConfig(name: String): FileConfiguration? {
        try {
            val file = plugin.dataFolder.resolve("$name.yml")
            if (!file.exists()) {
                plugin.saveResource("$name.yml", false)
            }
            val config = YamlConfiguration.loadConfiguration(file)

            config.save(file)
            return config
        } catch (e: Exception) {
            plugin.logger.severe("Failed to load $name.yml")
            e.printStackTrace()
            plugin.server.pluginManager.disablePlugin(plugin)
            return null
        }
    }

    fun getFile(name: String): File {
        return plugin.dataFolder.resolve("$name.yml")
    }

    fun getConfig(name: String): FileConfiguration {
        val file = getFile(name)
        if (!file.exists()) {
            plugin.saveResource("$name.yml", false)
        }
        return YamlConfiguration.loadConfiguration(file)
    }

    fun getConfig(file: File): FileConfiguration {
        return YamlConfiguration.loadConfiguration(file)
    }
}