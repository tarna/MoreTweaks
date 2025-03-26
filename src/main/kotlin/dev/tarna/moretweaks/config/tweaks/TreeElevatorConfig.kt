package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.DoubleOption

object TreeElevatorConfig {
    var enabled by BooleanOption("tweaks.tree_elevator.enabled", false)
    var range by DoubleOption("tweaks.tree_elevator.range", 0.5)
}