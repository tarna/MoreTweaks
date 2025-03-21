package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.PossessivePigmentConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.entity.PigZombie
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockBreakEvent

class PossessivePigmen : Tweak {
    override val id = "possessive_pigmen"

    private lateinit var radius: Number
    private lateinit var anger: Number
    private lateinit var blocks: List<Material>

    override fun reload() {
        radius = PossessivePigmentConfig.radius
        anger = PossessivePigmentConfig.anger
        blocks = PossessivePigmentConfig.blocks
    }

    @EventHandler(ignoreCancelled = true)
    fun onBlockBreak(event: BlockBreakEvent) {
        val player = event.player
        if (player.world.environment != World.Environment.NETHER) return

        val block = event.block
        if (!blocks.contains(block.type)) return

        val nearbyPigmen = block.location.getNearbyEntitiesByType(PigZombie::class.java, radius.toDouble())
        nearbyPigmen.forEach {
            it.anger = anger.toInt()
        }
    }
}