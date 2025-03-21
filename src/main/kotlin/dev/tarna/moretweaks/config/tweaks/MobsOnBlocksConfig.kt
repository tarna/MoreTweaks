package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object MobsOnBlocksConfig {
    var enabled by BooleanOption("tweaks.mob_on_blocks.enabled", false)
    var drowned by BooleanOption("tweaks.mob_on_blocks.mobs.drowned", true)
    var mooshroom by BooleanOption("tweaks.mob_on_blocks.mobs.mooshroom", true)
    var cow by BooleanOption("tweaks.mob_on_blocks.mobs.cow", true)
}