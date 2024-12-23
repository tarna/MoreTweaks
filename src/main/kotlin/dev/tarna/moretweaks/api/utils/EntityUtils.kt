package dev.tarna.moretweaks.api.utils

import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.inventory.ItemStack

val Entity.spawnEgg: ItemStack?
    get() {
        return try {
            Material.valueOf("${type.name}_SPAWN_EGG").toItemStack()
        } catch (e: IllegalArgumentException) {
            null
        }
    }