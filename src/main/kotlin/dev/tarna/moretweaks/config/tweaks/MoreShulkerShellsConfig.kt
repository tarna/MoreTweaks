package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object MoreShulkerShellsConfig {
    var enabled by BooleanOption("tweaks.more_shulker_shells.enabled", false)
    var amount by IntOption("tweaks.more_shulker_shells.amount", 2)
}