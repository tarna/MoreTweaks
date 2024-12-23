package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object OneLifeOneTotemConfig {
    var enabled by BooleanOption("tweaks.one_life_one_totem.enabled", false)
    var sleepingResets by BooleanOption("tweaks.one_life_one_totem.sleeping_resets", false)
}