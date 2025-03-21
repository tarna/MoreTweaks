package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.StartingInventoryConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent

class StartingInventory : Tweak {
    override val id = "starting_inventory"

    private lateinit var items: List<Material>

    override fun reload() {
        items = StartingInventoryConfig.items
    }

    @EventHandler
    fun onFirstJoin(event: PlayerJoinEvent) {
        val player = event.player
        if (player.hasPlayedBefore()) return

        player.inventory.addItem(*items.map { it.toItemStack()}.toTypedArray())
    }
}