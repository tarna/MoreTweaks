package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object StompTorchesConfig {
    var enabled by BooleanOption("tweaks.stomp_torches.enabled", false)
    var players by BooleanOption("tweaks.stomp_torches.players", true)
    var entities by BooleanOption("tweaks.stomp_torches.entities", false)
}