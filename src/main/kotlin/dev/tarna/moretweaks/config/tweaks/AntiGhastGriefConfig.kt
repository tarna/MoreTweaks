package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption

object AntiGhastGriefConfig {
    var enabled by BooleanOption("tweaks.anti_ghast_grief.enabled", false)
    var blocks by MaterialListOption("tweaks.anti_ghast_grief.blocks", emptyList())
}