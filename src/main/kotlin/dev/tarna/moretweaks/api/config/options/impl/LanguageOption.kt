package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.lang.Translatable

class LanguageOption(path: String = "settings.language") : StringOption(path, "en") {
    override fun get(): String {
        val languages = Translatable.languages.map { it.lang }
        val lang = config.getString("language") ?: default
        return if (languages.contains(lang)) lang else default
    }

    override fun set(value: String) {
        config.set("language", value)
    }
}