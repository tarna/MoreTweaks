package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.ItemFinderConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.commands.tweaks.ItemFinderCommand

class ItemFinder : Tweak {
    override val id = "item_finder"

    private lateinit var commandName: String

    override fun reload() {
        commandName = ItemFinderConfig.command
    }

    override fun enable() {
        plugin.commandManager.register(ItemFinderCommand(commandName))
    }

    override fun disable() {
        plugin.commandManager.unregister(ItemFinderCommand(commandName))
    }
}