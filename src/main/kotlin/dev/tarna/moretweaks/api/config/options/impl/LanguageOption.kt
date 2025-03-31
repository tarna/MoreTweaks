package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.lang.Translatable

class LanguageOption(path: String = "settings.language") : StringOption(path, "en_us") {
    override fun get(): String {
        val lang = config.getString(path) ?: default
        return if (Translatable.languageList.contains(lang)) lang else default
    }

    override fun set(value: String) {
        config.set("settings.language", value)
    }
}