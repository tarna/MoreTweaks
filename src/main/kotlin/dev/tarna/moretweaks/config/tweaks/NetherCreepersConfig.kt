package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object NetherCreepersConfig {
    var enabled by BooleanOption("tweaks.nether_creepers.enabled", false)
    var chance by IntOption("tweaks.nether_creepers.chance", 10)
}