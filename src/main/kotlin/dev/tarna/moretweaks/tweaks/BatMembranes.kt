package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.BatMembranesConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.chance
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.entity.Bat
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityDeathEvent

class BatMembranes : Tweak {
    override val id = "bat_membranes"

    private lateinit var chance: Number
    private lateinit var drop: Material
    private lateinit var amount: Number

    override fun reload() {
        chance = BatMembranesConfig.chance
        drop = BatMembranesConfig.drop
        amount = BatMembranesConfig.amount
    }

    @EventHandler
    fun onBatDeath(event: EntityDeathEvent) {
        val entity = event.entity
        if (entity !is Bat) return
        if (!chance(chance)) return

        val location = entity.location
        location.world.dropItemNaturally(location, drop.toItemStack(amount.toInt()))
    }
}