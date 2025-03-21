package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object FastPathsConfig {
    var enabled by BooleanOption("tweaks.fast_paths.enabled", false)
    var amplifier by IntOption("tweaks.fast_paths.amplifier", 1)
}