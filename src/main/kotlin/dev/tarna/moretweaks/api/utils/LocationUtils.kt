package dev.tarna.moretweaks.api.utils

import org.bukkit.Location
import org.bukkit.inventory.ItemStack

fun Location.dropItemWithoutVelocity(item: ItemStack) {
    world.dropItemWithoutVelocity(this, item)
}