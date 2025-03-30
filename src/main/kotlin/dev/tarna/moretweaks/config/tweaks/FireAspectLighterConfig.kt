package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object FireAspectLighterConfig {
    var enabled by BooleanOption("tweaks.fire_aspect_lighter.enabled", false)
    var campfire by BooleanOption("tweaks.fire_aspect_lighter.features.campfire", true)
    var candle by BooleanOption("tweaks.fire_aspect_lighter.features.candle", true)
    var netherPortal by BooleanOption("tweaks.fire_aspect_lighter.features.nether_portal", true)
    var tnt by BooleanOption("tweaks.fire_aspect_lighter.features.tnt", true)
}