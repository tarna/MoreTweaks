package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption
import org.bukkit.Material

object SoftPunchConfig {
    var enabled by BooleanOption("tweaks.soft_punch.enabled", false)
    var items by MaterialListOption("tweaks.soft_punch.items", listOf(Material.FEATHER))
}