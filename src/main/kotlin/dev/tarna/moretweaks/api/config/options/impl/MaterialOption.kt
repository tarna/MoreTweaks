package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.Material

class MaterialOption(val path: String, val default: Material) : ConfigOption<Material>() {
    override fun get(): Material {
        return Material.getMaterial(config.getString(path, default.name) ?: default.name) ?: default
    }

    override fun set(value: Material) {
        config.set(path, value.name)
        config.save(file)
    }
}