package dev.tarna.moretweaks.api.lang

import dev.tarna.moretweaks.MoreTweaks
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.InputStreamReader


class Language(val plugin: MoreTweaks, val lang: String) {
    val file = plugin.dataFolder.resolve("lang/$lang.yml")
    var messages: FileConfiguration

    init {
        if (!file.exists()) {
            plugin.saveResource("lang/$lang.yml", false)
        }

        messages = YamlConfiguration.loadConfiguration(file)

        matchConfig()
    }

    private fun matchConfig() {
        try {
            var hasUpdated = false
            val stream = checkNotNull(plugin.getResource("lang/$lang.yml"))
            val `is` = InputStreamReader(stream)
            val defConfig: YamlConfiguration = YamlConfiguration.loadConfiguration(`is`)
            for (key in defConfig.getConfigurationSection("")!!.getKeys(true)) {
                if (!messages.contains(key)) {
                    messages.set(key, defConfig[key])
                    hasUpdated = true
                }
            }
            for (key in messages.getConfigurationSection("")!!.getKeys(true)) {
                if (!defConfig.contains(key)) {
                    messages.set(key, null)
                    hasUpdated = true
                }
            }
            if (hasUpdated) messages.save(file)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}