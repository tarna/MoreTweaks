package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption
import dev.tarna.moretweaks.api.utils.parseDuration
import dev.tarna.moretweaks.api.utils.toDurationString
import java.time.Duration

class DurationOption(val path: String, val default: String) : ConfigOption<Duration>() {
    constructor(path: String, default: Duration) : this(path, default.toDurationString())

    override fun get(): Duration {
        return (config.getString(path, default) ?: default).parseDuration()
    }

    override fun set(value: Duration) {
        config.set(path, value.toDurationString())
        config.save(file)
    }
}