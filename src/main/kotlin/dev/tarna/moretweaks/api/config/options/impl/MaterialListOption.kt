package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.Material

class MaterialListOption(val path: String, val default: List<Material>) : ConfigOption<List<Material>>() {
    override fun get(): List<Material> {
        val list = config.getStringList(path)
        return if (list.isEmpty()) default else list.mapNotNull { Material.getMaterial(it) }
    }

    override fun set(value: List<Material>) {
        config.set(path, value.map { it.name })
        config.save(file)
    }

    fun add(value: Material) {
        val list = get().toMutableList()
        list.add(value)
        set(list)
    }

    fun remove(value: Material) {
        val list = get().toMutableList()
        list.remove(value)
        set(list)
    }
}