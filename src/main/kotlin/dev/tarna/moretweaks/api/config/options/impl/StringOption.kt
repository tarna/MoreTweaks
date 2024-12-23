package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption

open class StringOption(val path: String, val default: String) : ConfigOption<String>() {
    override fun get(): String {
        return config.getString(path, default) ?: default
    }

    override fun set(value: String) {
        config.set(path, value)
        config.save(file)
    }
}