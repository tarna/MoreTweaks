package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object ApiaristSuitConfig {
    var enabled by BooleanOption("tweaks.apiarist_suit.enabled", false)
}