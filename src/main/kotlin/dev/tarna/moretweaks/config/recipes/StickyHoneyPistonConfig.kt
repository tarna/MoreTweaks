package dev.tarna.moretweaks.config.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object StickyHoneyPistonConfig {
    var enabled by BooleanOption("recipes.sticky_honey_piston.enabled", false)
    var amount by IntOption("recipes.sticky_honey_piston.amount", 1)
}