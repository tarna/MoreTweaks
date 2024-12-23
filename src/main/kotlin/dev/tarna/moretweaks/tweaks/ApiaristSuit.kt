package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.entity.Bee
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityDamageByEntityEvent

class ApiaristSuit : Tweak {
    override val id = "apiarist_suit"

    @EventHandler
    fun onBeeSting(event: EntityDamageByEntityEvent) {
        val bee = event.damager as? Bee ?: return
        val victim = event.entity as? Player ?: return

        val inventory = victim.inventory
        if (
            inventory.helmet?.type == Material.CHAINMAIL_HELMET &&
            inventory.chestplate?.type == Material.CHAINMAIL_CHESTPLATE &&
            inventory.leggings?.type == Material.CHAINMAIL_LEGGINGS &&
            inventory.boots?.type == Material.CHAINMAIL_BOOTS
        ) {
            event.isCancelled = true
            bee.anger = 0
        }
    }
}