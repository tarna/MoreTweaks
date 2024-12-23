package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption

class IntOption(val path: String, val default: Int) : ConfigOption<Int>() {
    override fun get(): Int {
        return config.getInt(path, default)
    }

    override fun set(value: Int) {
        config.set(path, value)
        config.save(file)
    }
}