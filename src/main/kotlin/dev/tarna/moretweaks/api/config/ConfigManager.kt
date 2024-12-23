package dev.tarna.moretweaks.api.config

import dev.tarna.moretweaks.MoreTweaks
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.InputStreamReader

class ConfigManager(val plugin: MoreTweaks) {
    lateinit var file: File
    lateinit var config: FileConfiguration

    init {
        loadConfigFile()
    }

    private fun loadConfigFile() {
        file = plugin.dataFolder.resolve("config.yml")
        if (!file.exists()) {
            plugin.saveResource("config.yml", false)
        }
        config = YamlConfiguration.loadConfiguration(file)
        matchConfig()
    }

    private fun matchConfig() {
        try {
            var hasUpdated = false
            val stream = plugin.getResource(file.name) ?: error("Failed to load config file")
            val inputStream = InputStreamReader(stream)
            val defaultConfig = YamlConfiguration.loadConfiguration(inputStream)
            for (key in defaultConfig.getConfigurationSection("")!!.getKeys(true)) {
                if (!config.contains(key)) {
                    config.set(key, defaultConfig.get(key))
                    hasUpdated = true
                }
            }
            for (key in config.getConfigurationSection("")!!.getKeys(true)) {
                if (!defaultConfig.contains(key)) {
                    config.set(key, null)
                    hasUpdated = true
                }
            }
            if (hasUpdated) {
                config.save(file)
                plugin.logger.info("Updated config file")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun reload() {
        plugin.reloadConfig()
        loadConfigFile()
    }

    fun isTweakEnabled(tweak: String): Boolean {
        return config.getBoolean("tweaks.$tweak.enabled")
    }

    fun setTweakEnabled(tweak: String, enabled: Boolean) {
        config.set("tweaks.$tweak.enabled", enabled)
        config.save(file)
    }

    fun isRecipeEnabled(recipe: String): Boolean {
        return config.getBoolean("recipes.$recipe.enabled")
    }

    fun setRecipeEnabled(recipe: String, enabled: Boolean) {
        config.set("recipes.$recipe.enabled", enabled)
        config.save(file)
    }
}