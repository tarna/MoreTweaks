package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption

class DoubleOption(val path: String, val default: Double) : ConfigOption<Double>() {
    override fun get(): Double {
        return config.getDouble(path, default)
    }

    override fun set(value: Double) {
        config.set(path, value)
        config.save(file)
    }
}