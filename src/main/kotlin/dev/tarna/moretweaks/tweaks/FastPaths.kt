package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.FastPathsConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class FastPaths : Tweak {
    override val id = "fast_paths"

    private lateinit var amplifier: Number

    override fun reload() {
        amplifier = FastPathsConfig.amplifier
    }

    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        val block = event.to.block
        if (block.type != Material.DIRT_PATH) return
        val player = event.player
        player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 20, amplifier.toInt() - 1, false, false, false))
    }
}