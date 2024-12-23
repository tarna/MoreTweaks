package dev.tarna.moretweaks.api.config.objects.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object CraftableBellConfig {
    var enabled by BooleanOption("recipes.craftable_bell.enabled", false)
}