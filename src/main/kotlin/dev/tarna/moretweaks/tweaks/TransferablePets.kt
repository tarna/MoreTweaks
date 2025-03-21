package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.TransferablePetsConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.entity.Tameable
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.PlayerLeashEntityEvent
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.event.player.PlayerUnleashEntityEvent
import java.util.UUID

class TransferablePets : Tweak {
    override val id = "transferable_pets"

    private lateinit var allowedPets: List<EntityType>

    override fun reload() {
        allowedPets = TransferablePetsConfig.pets
    }

    private val leashedEntities = mutableMapOf<UUID, Tameable>()

    @EventHandler
    fun onRightClick(event: PlayerInteractAtEntityEvent) {
        val player = event.player
        val item = player.inventory.itemInMainHand
        if (item.type != Material.LEAD) return

        val clickedPlayer = event.rightClicked as? Player? ?: return
        val pet = leashedEntities[player.uniqueId] ?: return
        pet.owner = clickedPlayer
    }

    @EventHandler
    fun onLeash(event: PlayerLeashEntityEvent) {
        val entity = event.entity as? Tameable ?: return
        if (!entity.isTamed) return

        val player = event.player
        leashedEntities[player.uniqueId] = entity
    }

    @EventHandler
    fun onUnleash(event: PlayerUnleashEntityEvent) {
        val entity = event.entity as? Tameable ?: return
        if (!entity.isTamed) return

        val player = event.player
        leashedEntities.remove(player.uniqueId)
    }
}