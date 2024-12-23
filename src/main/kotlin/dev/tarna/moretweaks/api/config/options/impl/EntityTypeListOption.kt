package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import org.bukkit.entity.EntityType

class EntityTypeListOption(val path: String, val default: List<EntityType>) : ConfigOption<List<EntityType>>() {
    override fun get(): List<EntityType> {
        val list = config.getStringList(path)
        return if (list.isEmpty()) default else list.mapNotNull { EntityType.valueOf(it) }
    }

    override fun set(value: List<EntityType>) {
        config.set(path, value.map { it.name })
        config.save(file)
    }

    fun add(value: EntityType) {
        val list = get().toMutableList()
        list.add(value)
        set(list)
    }

    fun remove(value: EntityType) {
        val list = get().toMutableList()
        list.remove(value)
        set(list)
    }
}