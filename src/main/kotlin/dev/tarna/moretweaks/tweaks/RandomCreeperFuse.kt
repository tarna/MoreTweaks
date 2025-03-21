package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.RandomCreeperFuseConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.entity.Creeper
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.CreatureSpawnEvent

class RandomCreeperFuse : Tweak {
    override val id = "random_creeper_fuse"

    private lateinit var minFuse: Number
    private lateinit var maxFuse: Number

    override fun reload() {
        minFuse = RandomCreeperFuseConfig.minFuse
        maxFuse = RandomCreeperFuseConfig.maxFuse
    }

    @EventHandler
    fun onCreeperSpawn(event: CreatureSpawnEvent) {
        val creeper = event.entity as? Creeper ?: return

        val rand = (minFuse.toInt()..maxFuse.toInt()).random()
        creeper.maxFuseTicks = rand
        creeper.fuseTicks = rand

        val nearbyPlayers = creeper.location.getNearbyPlayers(10.0).firstOrNull() ?: return
        nearbyPlayers.sendMessage("A creeper has spawned with a fuse of ${creeper.maxFuseTicks} ticks!")
    }
}