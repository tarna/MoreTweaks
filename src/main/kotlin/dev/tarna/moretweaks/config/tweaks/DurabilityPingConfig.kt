package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.*
import net.kyori.adventure.key.Key
import net.kyori.adventure.sound.Sound

object DurabilityPingConfig {
    var enabled by BooleanOption("tweaks.durability_ping.enabled", false)
    var threshold by IntOption("tweaks.durability_ping.threshold", 5)
    var messageType by MessageTypeOption("tweaks.durability_ping.message_type", MessageTypeOption.MessageType.TITLE)
    var sound by SoundOption("tweaks.durability_ping.sound", Sound.sound(Key.key("minecraft:block.note_block.chime"), Sound.Source.MUSIC, 1f, 1f))
}