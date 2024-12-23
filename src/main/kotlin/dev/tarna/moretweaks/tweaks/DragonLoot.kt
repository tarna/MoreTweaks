package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.DragonLootConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.entity.EnderDragon
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityDeathEvent

class DragonLoot : Tweak {
    override val id = "dragon_loot"

    private lateinit var drops: List<Material>

    override fun reload() {
        drops = DragonLootConfig.drops
    }

    @EventHandler
    fun onDragonDeath(event: EntityDeathEvent) {
        if (event.entity !is EnderDragon) return

        val drops = drops.map { it.toItemStack() }
        event.drops.addAll(drops)
    }
}