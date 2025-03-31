package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.SoundOption
import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.DoubleOption
import net.kyori.adventure.key.Key
import net.kyori.adventure.sound.Sound

object TraderNotifyConfig {
    var enabled by BooleanOption("tweaks.trader_notify.enabled", false)
    var playSound by BooleanOption("tweaks.trader_notify.play_sound", true)
    var sound by SoundOption("tweaks.trader_notify.sound", Sound.sound(Key.key("minecraft:block.note_block.chime"), Sound.Source.MUSIC, 1f, 1f))
    var radius by DoubleOption("tweaks.trader_notify.radius", 30.0)
}