package dev.tarna.moretweaks.api.utils

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

fun CommandSender.send(vararg messages: String) {
    messages.forEach { sendMessage(!it) }
}

fun Player.giveOrDrop(item: ItemStack) {
    if (inventory.firstEmpty() != -1) {
        inventory.addItem(item)
    } else {
        world.dropItemNaturally(location, item)
    }
}