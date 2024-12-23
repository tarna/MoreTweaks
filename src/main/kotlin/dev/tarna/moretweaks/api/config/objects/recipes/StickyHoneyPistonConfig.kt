package dev.tarna.moretweaks.api.config.objects.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object StickyHoneyPistonConfig {
    var enabled by BooleanOption("recipes.sticky_honey_piston.enabled", false)
}