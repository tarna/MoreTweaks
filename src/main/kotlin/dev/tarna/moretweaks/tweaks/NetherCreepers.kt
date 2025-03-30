package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.chance
import dev.tarna.moretweaks.config.tweaks.NetherCreepersConfig
import org.bukkit.World
import org.bukkit.entity.Creeper
import org.bukkit.entity.PigZombie
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntitySpawnEvent

class NetherCreepers : Tweak {
    override val id = "nether_creepers"

    private lateinit var chance: Number

    override fun reload() {
        chance = NetherCreepersConfig.chance
    }

    @EventHandler
    fun onCreeperSpawn(event: EntitySpawnEvent) {
        val world = event.location.world ?: return
        if (world.environment != World.Environment.NETHER) return
        val piglin = event.entity as? PigZombie ?: return
        if (!chance(chance)) return

        piglin.remove()
        val creeper = world.spawn(event.location, Creeper::class.java)
        creeper.isPowered = true
    }
}