package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption

class BooleanOption(val path: String, val default: Boolean) : ConfigOption<Boolean>() {
    override fun get(): Boolean {
        return config.getBoolean(path, default)
    }

    override fun set(value: Boolean) {
        config.set(path, value)
        config.save(file)
    }
}