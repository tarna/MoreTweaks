package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object XPBottlingConfig {
    var enabled by BooleanOption("tweaks.xp_bottling.enabled", false)
    var expPerBottle by IntOption("tweaks.xp_bottling.xp_per_bottle", 10)
}