package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object UnstableTNTConfig {
    var enabled by BooleanOption("tw.unstable_tnt.enabled", false)
}