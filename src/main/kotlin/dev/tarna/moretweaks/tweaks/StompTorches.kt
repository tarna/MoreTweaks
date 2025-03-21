package dev.tarna.moretweaks.tweaks

import com.destroystokyo.paper.event.entity.EntityJumpEvent
import dev.tarna.moretweaks.config.tweaks.StompTorchesConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerMoveEvent
import kotlin.properties.Delegates

class StompTorches : Tweak {
    override val id = "stomp_torches"

    private var players by Delegates.notNull<Boolean>()
    private var entities by Delegates.notNull<Boolean>()

    override fun reload() {
        players = StompTorchesConfig.players
        entities = StompTorchesConfig.entities
    }

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        if (!players) return
        if (event.from.blockY == event.to.blockY) return
        val block = event.to.block
        checkBlock(block)
    }

    @EventHandler
    fun onEntityJump(event: EntityJumpEvent) {
        if (!entities) return
        val entity = event.entity
        val block = entity.location.block
        checkBlock(block)
    }

    private fun checkBlock(block: Block) {
        if (block.type != Material.TORCH) return
        block.breakNaturally()
    }
}