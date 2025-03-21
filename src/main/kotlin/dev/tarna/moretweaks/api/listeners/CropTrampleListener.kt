package dev.tarna.moretweaks.api.listeners

import dev.tarna.moretweaks.api.event.CropTrampleEvent
import dev.tarna.moretweaks.api.utils.isFarmLand
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityInteractEvent
import org.bukkit.event.player.PlayerInteractEvent

class CropTrampleListener : Listener {
    @EventHandler
    fun onMobTrample(event: EntityInteractEvent) {
        if (event.entity is Player) return
        val block = event.block
        if (block.isFarmLand) {
            val cropTrampleEvent = CropTrampleEvent(event.entity, CropTrampleEvent.TrampleCause.MOB, block)
            Bukkit.getPluginManager().callEvent(cropTrampleEvent)
            if (cropTrampleEvent.isCancelled) event.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerTrample(event: PlayerInteractEvent) {
        val block = event.clickedBlock ?: return
        if (event.action == Action.PHYSICAL && block.isFarmLand) {
            val cropTrampleEvent = CropTrampleEvent(event.player, CropTrampleEvent.TrampleCause.PLAYER, block)
            Bukkit.getPluginManager().callEvent(cropTrampleEvent)
            if (cropTrampleEvent.isCancelled) event.isCancelled = true
        }
    }
}