package dev.tarna.moretweaks.api.utils

import dev.tarna.moretweaks.api.config.options.impl.MessageTypeOption
import dev.tarna.moretweaks.api.config.options.impl.MessageTypeOption.MessageType.*
import net.kyori.adventure.title.TitlePart
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

fun Player.send(type: MessageTypeOption.MessageType, message: String) {
    when (type) {
        ACTION_BAR -> player?.sendActionBar(!message)
        CHAT -> player?.send(message)
        TITLE -> player?.sendTitlePart(TitlePart.TITLE, !message)
    }
}