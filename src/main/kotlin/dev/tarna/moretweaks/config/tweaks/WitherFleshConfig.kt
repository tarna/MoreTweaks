package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object WitherFleshConfig {
    var enabled by BooleanOption("tweaks.wither_flesh.enabled", false)
    var chance by IntOption("tweaks.wither_flesh.chance", 100)
    var amount by IntOption("tweaks.wither_flesh.amount", 1)
}