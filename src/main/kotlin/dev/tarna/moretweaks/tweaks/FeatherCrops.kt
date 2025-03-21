package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.FeatherCropsConfig
import dev.tarna.moretweaks.api.event.CropTrampleEvent
import dev.tarna.moretweaks.api.listeners.CropTrampleListener
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.chance
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler

class FeatherCrops : Tweak {
    override val id = "feather_crops"

    private lateinit var chance: Number

    override fun reload() {
        chance = FeatherCropsConfig.chance
    }

    override fun requiredCustomListeners() = listOf(CropTrampleListener::class.java)

    @EventHandler
    fun onCropTrample(event: CropTrampleEvent) {
        if (event.cause == CropTrampleEvent.TrampleCause.PLAYER && chance(chance)) {
            val player = event.entity as Player
            val boots = player.inventory.boots ?: return
            val enchantments = boots.enchantments
            if (!enchantments.containsKey(Enchantment.FEATHER_FALLING)) return
            event.isCancelled = true
        }
    }
}