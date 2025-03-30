package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.allSaplings
import dev.tarna.moretweaks.api.utils.getNearbyBlocks
import dev.tarna.moretweaks.config.tweaks.TreeTwerkConfig
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerToggleSneakEvent

class TreeTwerk : Tweak {
    override val id = "tree_twerk"

    private lateinit var radius: Number

    override fun reload() {
        radius = TreeTwerkConfig.radius
    }

    @EventHandler
    fun onTwerk(event: PlayerToggleSneakEvent) {
        if (!event.isSneaking) return

        val player = event.player
        val blocks = player.getNearbyBlocks(radius.toInt(), *allSaplings.toTypedArray())
        if (blocks.isEmpty()) return

        blocks.forEach { block -> block.applyBoneMeal(BlockFace.UP) }
    }
}