package dev.tarna.moretweaks.config.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object TurtleBoxConfig {
    var enabled by BooleanOption("recipes.turtle_box.enabled", false)
    var amount by IntOption("recipes.turtle_box.amount", 1)
}