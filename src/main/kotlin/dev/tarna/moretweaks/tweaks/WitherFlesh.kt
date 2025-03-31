package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.chance
import dev.tarna.moretweaks.api.utils.not
import dev.tarna.moretweaks.api.utils.toItemStack
import dev.tarna.moretweaks.config.tweaks.WitherFleshConfig
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Projectile
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDeathEvent

class WitherFlesh : Tweak {
    override val id = "wither_flesh"

    private lateinit var chance: Number
    private lateinit var amount: Number

    override fun reload() {
        chance = WitherFleshConfig.chance
        amount = WitherFleshConfig.amount
    }

    @EventHandler
    fun onDeath(event: EntityDeathEvent) {
        val entity = event.entity
        val damage = entity.lastDamageCause ?: return
        if (!killedByWither(damage)) return
        if (!chance(chance)) return

        event.drops.clear()
        event.drops.add(Material.ROTTEN_FLESH.toItemStack(amount))
    }

    private fun killedByWither(event: EntityDamageEvent): Boolean {
        return when {
            event.cause == EntityDamageEvent.DamageCause.WITHER -> true
            event.cause == EntityDamageEvent.DamageCause.PROJECTILE && event is EntityDamageByEntityEvent -> {
                val projectile = event.damager as Projectile? ?: return false
                projectile.type == EntityType.WITHER_SKULL
            }
            event.cause == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION && event is EntityDamageByEntityEvent -> {
                val entity = event.damager
                entity.type == EntityType.WITHER || entity.type == EntityType.WITHER_SKULL
            }
            else -> false
        }
    }
}