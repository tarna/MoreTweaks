package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.block.data.type.TNT
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent

class UnstableTNT : Tweak {
    override val id = "unstable_tnt"

    @EventHandler
    fun onRightClick(event: PlayerInteractEvent) {
        if (!event.action.isRightClick) return

        val item = event.item ?: return
        if (item.type != Material.GUNPOWDER) return

        val block = event.clickedBlock ?: return
        if (block.type != Material.TNT) return

        val blockData = block.blockData as TNT
        if (blockData.isUnstable) return

        block.blockData = blockData.apply { isUnstable = true }
        item.amount--
    }
}