package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.config.tweaks.TreeElevatorConfig
import org.bukkit.event.EventHandler
import org.bukkit.event.world.StructureGrowEvent

class TreeElevator : Tweak {
    override val id = "tree_elevator"

    private lateinit var range: Number

    override fun reload() {
        range = TreeElevatorConfig.range
    }

    @EventHandler
    fun onTreeGrow(event: StructureGrowEvent) {
        val location = event.location
        val player = location.getNearbyPlayers(range.toDouble()).firstOrNull() ?: return

        val treeBlocks = event.blocks
        val highestBlock = treeBlocks
            .map { it.location }
            .filter { it.x == location.x && it.z == location.z }
            .maxByOrNull { it.y } ?: return

        player.teleport(highestBlock.add(0.5, 1.0, 0.5))
    }
}