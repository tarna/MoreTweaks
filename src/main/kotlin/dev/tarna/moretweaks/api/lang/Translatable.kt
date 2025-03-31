package dev.tarna.moretweaks.api.lang

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.utils.mm
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver

object Translatable {
    private val plugin = MoreTweaks.getPlugin()

    val languageList = listOf(
        "en_us",
        "es_mx",
    )
    private val languages = mutableListOf<Language>()

    lateinit var currentLanguage: Language

    fun init(lang: String) {
        val langList = listOf(
            "en_us",
            "es_mx",
        )

        langList.forEach {
            languages.add(Language(plugin, it))
            plugin.logger.info("Loaded language $it")
        }

        currentLanguage = getLanguage(lang)
        plugin.logger.info("Language set to ${currentLanguage.lang}")
    }

    fun getString(key: String): String {
        return currentLanguage.messages.getString(key) ?: getLanguage("en_us").messages.getString(key) ?: key
    }

    fun get(key: String, vararg resolvers: TagResolver): Component {
        val msg = getString(key)
        return mm.deserialize(msg, *resolvers)
    }

    fun getLanguage(lang: String): Language {
        return languages.first { it.lang == lang }
    }
}