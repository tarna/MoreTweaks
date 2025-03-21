package dev.tarna.moretweaks.config.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.FloatOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object ZombieLeatherConfig {
    var enabled by BooleanOption("recipes.zombie_leather.enabled", false)
    var experience by FloatOption("recipes.zombie_leather.experience", 10f)
    var cookingTime by IntOption("recipes.zombie_leather.cooking_time", 100)
    var amount by IntOption("recipes.zombie_leather.amount", 1)
}