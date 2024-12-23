package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.Bukkit
import org.bukkit.Location

class LocationOption(val path: String, val default: Location) : ConfigOption<Location>() {
    override fun get(): Location {
        val loc = config.getString(path) ?: return default
        val split = loc.split(",")
        return Location(
            Bukkit.getWorld(split[0]) ?: return default,
            split[1].toDouble(),
            split[2].toDouble(),
            split[3].toDouble(),
            split[4].toFloat(),
            split[5].toFloat()
        )
    }

    override fun set(value: Location) {
        config.set(path, "${value.world.name},${value.x},${value.y},${value.z},${value.yaw},${value.pitch}")
        config.save(file)
    }
}