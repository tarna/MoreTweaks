package dev.tarna.moretweaks.api.lang

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.utils.mm
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver

object Translatable {
    val plugin = MoreTweaks.getPlugin()
    val languages = mutableListOf<Language>()

    lateinit var currentLanguage: Language

    fun init(lang: String) {
        languages.add(Language(plugin, "en"))

        currentLanguage = getLanguage(lang)
    }

    fun getString(key: String): String {
        return currentLanguage.messages.getString(key) ?: "Missing translation for $key"
    }

    fun get(key: String, vararg resolvers: TagResolver): Component {
        val msg = getString(key)
        return mm.deserialize(msg, *resolvers)
    }

    fun getLanguage(lang: String): Language {
        return languages.first { it.lang == lang }
    }
}