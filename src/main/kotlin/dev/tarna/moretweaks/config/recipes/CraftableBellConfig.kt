package dev.tarna.moretweaks.config.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object CraftableBellConfig {
    var enabled by BooleanOption("recipes.craftable_bell.enabled", false)
    var amount by IntOption("recipes.craftable_bell.amount", 1)
}