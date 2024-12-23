package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.Bukkit
import org.bukkit.World

class WorldListOption(val path: String, val default: List<String>) : ConfigOption<List<World>>() {
    override fun get(): List<World> {
        val worlds = config.getStringList(path)
        return worlds.mapNotNull { worldName -> Bukkit.getWorld(worldName) }
    }

    override fun set(value: List<World>) {
        config.set(path, value.map { it.name })
        config.save(file)
    }
}