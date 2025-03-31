package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.StringOption

object RealTimeClockConfig {
    var enabled by BooleanOption("tweaks.real_time_clock.enabled", false)
    var command by StringOption("tweaks.real_time_clock.command", "realtimeclock")
    var permission by StringOption("tweaks.real_time_clock.permission", "moretweaks.realtimeclock")
}