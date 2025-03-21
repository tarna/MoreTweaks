package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object ChestSortingConfig {
    var enabled by BooleanOption("tweaks.chest_sorting.enabled", false)
    var radius by IntOption("tweaks.chest_sorting.radius", 1)
}