package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.AlwaysDropConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockBreakEvent

class AlwaysDrop : Tweak {
    override val id = "always_drop"

    private lateinit var blocks: List<Material>

    override fun reload() {
        blocks = AlwaysDropConfig.blocks
    }

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        val player = event.player
        if (player.gameMode == GameMode.CREATIVE) return
        val block = event.block
        if (block.type !in blocks) return

        block.drops.clear()
        block.world.dropItemNaturally(block.location, block.type.toItemStack())
    }
}