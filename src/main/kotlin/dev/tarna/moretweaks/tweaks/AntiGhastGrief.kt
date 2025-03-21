package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.AntiGhastGriefConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.entity.Fireball
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityExplodeEvent

class AntiGhastGrief : Tweak {
    override val id = "anti_ghast_grief"

    private lateinit var blocks: List<Material>

    override fun reload() {
        blocks = AntiGhastGriefConfig.blocks
    }

    @EventHandler
    fun onGhastFireball(event: EntityExplodeEvent) {
        if (event.entity !is Fireball) return

        if (blocks.isEmpty()) {
            event.blockList().clear()
        } else {
            event.blockList().removeIf { it.type in blocks }
        }
    }
}