package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object SlimeCreamConfig {
    var enabled by BooleanOption("tweaks.slime_cream.enabled", false)
}