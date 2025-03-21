package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.SoftPunchConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityDamageByEntityEvent

class SoftPunch : Tweak {
    override val id = "soft_punch"

    private lateinit var items: List<Material>

    override fun reload() {
        items = SoftPunchConfig.items
    }

    @EventHandler
    fun onDamage(event: EntityDamageByEntityEvent) {
        val attacker = event.damager as? Player ?: return

        val tool = attacker.inventory.itemInMainHand.type
        if (items.contains(tool)) {
            event.damage = 0.0
        }
    }
}