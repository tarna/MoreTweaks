package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.DurationOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption
import org.bukkit.Material

object DeadSaplingsConfig {
    var enabled by BooleanOption("tweaks.dead_saplings.enabled", false)
    var delay by DurationOption("tweaks.dead_saplings.delay", "1s")
    var time by DurationOption("tweaks.dead_saplings.time", "1m")
    var blocks by MaterialListOption("tweaks.dead_saplings.blocks", listOf(Material.SAND, Material.RED_SAND))
}