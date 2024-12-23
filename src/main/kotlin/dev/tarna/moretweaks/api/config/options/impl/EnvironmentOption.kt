package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.World.Environment

class EnvironmentOption(val path: String, val default: String) : ConfigOption<Environment>() {
    override fun get(): Environment {
        return Environment.valueOf(config.getString(path) ?: default)
    }

    override fun set(value: Environment) {
        config.set(path, value.name)
        config.save(file)
    }
}