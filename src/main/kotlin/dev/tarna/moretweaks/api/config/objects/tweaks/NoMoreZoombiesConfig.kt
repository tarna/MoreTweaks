package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object NoMoreZoombiesConfig {
    var enabled by BooleanOption("tweaks.no_more_zoombies.enabled", false)
}