package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.DoubleOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption
import org.bukkit.Material

object PossessivePigmentConfig {
    var enabled by BooleanOption("tweaks.possessive_pigment.enabled", false)
    var radius by DoubleOption("tweaks.possessive_pigment.radius", 20.0)
    var anger by IntOption("tweaks.possessive_pigment.anger", 30)
    var blocks by MaterialListOption("tweaks.possessive_pigment.blocks", listOf(Material.NETHER_QUARTZ_ORE))
}