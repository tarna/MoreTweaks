package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object AntiZombieBreachConfig {
    var enabled by BooleanOption("tweaks.anti_zombie_breach.enabled", false)
}