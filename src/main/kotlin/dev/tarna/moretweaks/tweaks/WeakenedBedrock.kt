package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.WeakenedBedrockConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.chance
import dev.tarna.moretweaks.api.utils.getNearbyBlocks
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.LingeringPotionSplashEvent
import org.bukkit.potion.PotionType

class WeakenedBedrock : Tweak {
    override val id = "weakened_bedrock"

    private lateinit var radius: Number
    private lateinit var chance: Number
    private lateinit var speed: Number
    private lateinit var worlds: List<World>

    override fun reload() {
        radius = WeakenedBedrockConfig.radius
        chance = WeakenedBedrockConfig.chance
        speed = WeakenedBedrockConfig.speed
        worlds = WeakenedBedrockConfig.worlds
    }

    @EventHandler
    fun onLingeringPotionThrow(event: LingeringPotionSplashEvent) {
        val areaEffectCloud = event.areaEffectCloud
        val potionType = areaEffectCloud.basePotionType ?: return
        if (potionType != PotionType.WEAKNESS && potionType != PotionType.LONG_WEAKNESS) return
        if (!worlds.contains(areaEffectCloud.world)) return

        val blocks = areaEffectCloud.location.getNearbyBlocks(radius.toInt(), Material.BEDROCK).shuffled()
        for (i in blocks.indices) {
            plugin.server.scheduler.runTaskLater(plugin, Runnable {
                if (chance(chance.toInt())) blocks[i].type = Material.COBBLESTONE
            }, speed.toInt() * i.toLong())
        }
    }
}