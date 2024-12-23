package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Ageable
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.CreatureSpawnEvent

class NoMoreZoombies : Tweak {
    override val id = "no_more_zoombies"

    private val zoombies = mutableListOf(
        EntityType.ZOMBIE,
        EntityType.ZOMBIE_VILLAGER
    )

    @EventHandler
    fun onBabyZombieSpawn(event: CreatureSpawnEvent) {
        val entity = event.entity
        if (entity !is Ageable) return
        if (!zoombies.contains(entity.type)) return
        if (entity.isAdult) return

        val speed = entity.getAttribute(Attribute.MOVEMENT_SPEED)?.baseValue ?: return
        entity.getAttribute(Attribute.MOVEMENT_SPEED)?.baseValue = speed - 0.5
    }
}