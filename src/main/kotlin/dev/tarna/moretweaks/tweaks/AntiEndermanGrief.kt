package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.AntiEndermanGriefConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.entity.Enderman
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityChangeBlockEvent

class AntiEndermanGrief : Tweak {
    override val id = "anti_enderman_grief"

    private lateinit var blocks: List<Material>

    override fun reload() {
        blocks = AntiEndermanGriefConfig.blocks
    }

    @EventHandler(ignoreCancelled = true)
    fun onEndermanGrief(event: EntityChangeBlockEvent) {
        if (event.entity !is Enderman) return

        event.isCancelled = blocks.isEmpty() || blocks.contains(event.block.type)
    }
}