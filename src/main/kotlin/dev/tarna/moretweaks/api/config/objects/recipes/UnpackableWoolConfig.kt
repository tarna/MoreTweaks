package dev.tarna.moretweaks.api.config.objects.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object UnpackableWoolConfig {
    var enabled by BooleanOption("recipes.unpackable_wool.enabled", false)
    var amount by IntOption("recipes.unpackable_wool.amount", 4)
}