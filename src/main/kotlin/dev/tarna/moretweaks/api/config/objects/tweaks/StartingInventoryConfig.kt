package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption

object StartingInventoryConfig {
    var enabled by BooleanOption("tweaks.starting_inventory.enabled", false)
    var items by MaterialListOption("tweaks.starting_inventory.items", listOf())
}