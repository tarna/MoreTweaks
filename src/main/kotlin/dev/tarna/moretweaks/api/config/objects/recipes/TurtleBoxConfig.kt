package dev.tarna.moretweaks.api.config.objects.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object TurtleBoxConfig {
    var enabled by BooleanOption("recipes.turtle_box.enabled", false)
}