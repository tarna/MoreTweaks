package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object AnvilCostLimiterConfig {
    var enabled by BooleanOption("tweaks.anvil_cost_limiter.enabled", false)
    var limit by IntOption("tweaks.anvil_cost_limiter.limit", 39)
}