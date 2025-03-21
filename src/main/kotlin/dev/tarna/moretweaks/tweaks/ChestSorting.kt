package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.ChestSortingConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.getNearbyBlocks
import dev.tarna.moretweaks.api.utils.sort
import org.bukkit.Material
import org.bukkit.block.Chest
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent

class ChestSorting : Tweak {
    override val id = "chest_sorting"

    private lateinit var radius: Number

    override fun reload() {
        radius = ChestSortingConfig.radius
    }

    @EventHandler
    fun onButtonClick(event: PlayerInteractEvent) {
        if (!event.action.isRightClick) return

        val block = event.clickedBlock ?: return
        if (!block.type.name.lowercase().contains("button")) return

        val nearbyBlocks = block.location.getNearbyBlocks(radius.toInt(), Material.CHEST)
            .map { it.state }
        if (nearbyBlocks.isEmpty()) return

        val chests = nearbyBlocks.filterIsInstance<Chest>()
        chests.forEach { chest ->
            chest.blockInventory.sort()
        }
    }
}