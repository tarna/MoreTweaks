package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import net.kyori.adventure.key.Key
import net.kyori.adventure.sound.Sound

class SoundOption(val path: String, val default: Sound) : ConfigOption<Sound>() {
    override fun get(): Sound {
        val value = config.getString(path) ?: return default
        val split = value.split(",")
        if (split.size != 3) return default
        return Sound.sound(Key.key(split[0]), Sound.Source.MUSIC, split[1].toFloat(), split[2].toFloat())
    }

    override fun set(value: Sound) {
        config.set(path, value)
        config.save(file)
    }
}