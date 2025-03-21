package dev.tarna.moretweaks.config.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object UnpackableIceConfig {
    var enabled by BooleanOption("recipes.unpackable_ice.enabled", false)
    var amount by IntOption("recipes.unpackable_ice.amount", 9)
}