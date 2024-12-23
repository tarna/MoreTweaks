package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.entity.EntityType

class EntityTypeOption(val path: String, val default: EntityType) : ConfigOption<EntityType>() {
    override fun get(): EntityType {
        return EntityType.valueOf(config.getString(path) ?: return default)
    }

    override fun set(value: EntityType) {
        config.set(path, value.name)
        config.save(file)
    }
}