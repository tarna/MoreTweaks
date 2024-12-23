package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption
import org.bukkit.Material

object DragonLootConfig {
    var enabled by BooleanOption("tweaks.dragon_loot.enabled", false)
    var drops by MaterialListOption("tweaks.dragon_loot.drops", listOf(Material.ELYTRA))
}