package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption

object AntiEndermanGriefConfig {
    var enabled by BooleanOption("tweaks.anti_enderman_grief.enabled", false)
    var blocks by MaterialListOption("tweaks.anti_enderman_grief.blocks", emptyList())
}