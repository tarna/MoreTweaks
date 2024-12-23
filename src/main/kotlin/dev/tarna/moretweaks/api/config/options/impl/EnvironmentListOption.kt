package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.World.Environment

class EnvironmentListOption(val path: String, val default: List<Environment>) : ConfigOption<List<Environment>>() {
    override fun get(): List<Environment> {
        val list = config.getStringList(path)
        return if (list.isEmpty()) default else list.map { Environment.valueOf(it) }
    }

    override fun set(value: List<Environment>) {
        config.set(path, value.map { it.name })
        config.save(file)
    }

    fun add(value: Environment) {
        val list = get().toMutableList()
        list.add(value)
        set(list)
    }

    fun remove(value: Environment) {
        val list = get().toMutableList()
        list.remove(value)
        set(list)
    }
}