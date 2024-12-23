package dev.tarna.moretweaks.api.utils

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import org.bukkit.util.Vector

fun Material.toItemStack(amount: Int = 1) = ItemStack(this, amount)

fun <T : Any> ItemStack.setValue(key: String, value: T, type: PersistentDataType<*, T>) {
    val meta = itemMeta
    meta.persistentDataContainer.set(Key.get(key), type, value)
    itemMeta = meta
}

fun <T> ItemStack.getValue(key: String, type: PersistentDataType<*, T>): T? {
    return itemMeta.persistentDataContainer.get(Key.get(key), type)
}

fun ItemStack.setName(name: String) {
    val meta = itemMeta
    meta.displayName(!name)
    itemMeta = meta
}

fun ItemStack.setLore(vararg lore: String) {
    val meta = itemMeta
    meta.lore(!lore.toList())
    itemMeta = meta
}

fun World.dropItemWithoutVelocity(location: Location, item: ItemStack, gravity: Boolean = true) {
    val dropped = dropItemNaturally(location, item)
    dropped.velocity = Vector(0, 0, 0)
    dropped.setGravity(gravity)
}

val Block.isCauldron get() = type == Material.CAULDRON || type == Material.WATER_CAULDRON || type == Material.LAVA_CAULDRON