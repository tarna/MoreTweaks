package dev.tarna.moretweaks.api.config.options

import dev.tarna.moretweaks.api.config.ConfigUtils
import org.bukkit.configuration.file.FileConfiguration
import java.io.File

abstract class ConfigOption<T> {
    abstract fun get(): T
    abstract fun set(value: T)

    override fun toString(): String {
        return get().toString()
    }

    operator fun setValue(thisRef: Any?, property: Any?, value: T) {
        set(value)
    }

    operator fun getValue(thisRef: Any?, property: Any?): T {
        return get()
    }

    val file: File
        get() = ConfigUtils.getFile("config")
    val config: FileConfiguration
        get() = ConfigUtils.getConfig("config")
}