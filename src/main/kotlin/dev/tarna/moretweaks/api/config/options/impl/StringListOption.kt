package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption

class StringListOption(val path: String, val default: List<String>) : ConfigOption<List<String>>() {
    override fun get(): List<String> {
        val list = config.getStringList(path)
        return if (list.isEmpty()) default else list
    }

    override fun set(value: List<String>) {
        config.set(path, value)
        config.save(file)
    }

    fun add(value: String) {
        val list = get().toMutableList()
        list.add(value)
        set(list)
    }

    fun remove(value: String) {
        val list = get().toMutableList()
        list.remove(value)
        set(list)
    }
}