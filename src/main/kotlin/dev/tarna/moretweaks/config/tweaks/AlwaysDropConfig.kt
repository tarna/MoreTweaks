package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption

object AlwaysDropConfig {
    var enabled by BooleanOption("tweaks.always_drop_glass.enabled", false)
    var blocks by MaterialListOption("tweaks.always_drop_glass.blocks", listOf())
}