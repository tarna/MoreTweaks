package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object TreeTwerkConfig {
    var enabled by BooleanOption("tweaks.tree_twerk.enabled", false)
    var radius by IntOption("tweaks.tree_twerk.radius", 3)
}