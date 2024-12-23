package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.Bukkit
import org.bukkit.World

class WorldOption(val path: String, val default: String) : ConfigOption<World>() {
    override fun get(): World {
        val world = config.getString(path) ?: return defaultWorld
        return Bukkit.getWorld(world) ?: defaultWorld
    }

    override fun set(value: World) {
        config.set(path, value.name)
        config.save(file)
    }

    private val defaultWorld: World
        get() = Bukkit.getWorld(default) ?: Bukkit.getWorlds()[0]
}