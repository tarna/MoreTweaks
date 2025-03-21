package dev.tarna.moretweaks.api.config.objects.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object CraftableEnchantedGoldenAppleConfig {
    var enabled by BooleanOption("recipes.craftable_enchanted_golden_apple.enabled", false)
    var amount by IntOption("recipes.craftable_enchanted_golden_apple.amount", 1)
}