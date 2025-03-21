package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object AntiCreeperGriefConfig {
    var enabled by BooleanOption("tweaks.anti_creeper_grief.enabled", false)
    var doBlockDamage by BooleanOption("tweaks.anti_creeper_grief.block_damage", false)
    var doEntityDamage by BooleanOption("tweaks.anti_creeper_grief.entity_damage", false)
}