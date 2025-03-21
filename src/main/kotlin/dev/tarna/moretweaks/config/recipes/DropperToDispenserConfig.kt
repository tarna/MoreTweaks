package dev.tarna.moretweaks.config.recipes

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object DropperToDispenserConfig {
    var enabled by BooleanOption("recipes.dropper_to_dispenser.enabled", false)
    var amount by IntOption("recipes.dropper_to_dispenser.amount", 1)
}