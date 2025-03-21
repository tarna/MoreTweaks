package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object FeatherCropsConfig {
    var enabled by BooleanOption("tweaks.feather_crops.enabled", false)
    var chance by IntOption("tweaks.feather_crops.chance", 100)
}