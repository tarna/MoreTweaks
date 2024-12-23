package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.entity.Zombie
import org.bukkit.entity.ZombieVillager
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityBreakDoorEvent

class AntiZombieBreach : Tweak {
    override val id = "anti_zombie_breach"

    @EventHandler(ignoreCancelled = true)
    fun onZombieBreach(event: EntityBreakDoorEvent) {
        if (event.entity !is Zombie && event.entity !is ZombieVillager) return
    }
}