package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption

class FloatOption(val path: String, val default: Float) : ConfigOption<Float>() {
    override fun get(): Float {
        return config.getDouble(path, default.toDouble()).toFloat()
    }

    override fun set(value: Float) {
        config.set(path, value)
        config.save(file)
    }
}