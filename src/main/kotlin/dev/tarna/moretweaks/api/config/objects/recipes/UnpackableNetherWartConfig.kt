package dev.tarna.moretweaks.api.config.objects.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object UnpackableNetherWartConfig {
    var enabled by BooleanOption("recipes.unpackable_nether_wart.enabled", false)
    var amount by IntOption("recipes.unpackable_nether_wart.amount", 9)
}