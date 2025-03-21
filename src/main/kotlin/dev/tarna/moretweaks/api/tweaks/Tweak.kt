package dev.tarna.moretweaks.api.tweaks

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.lang.Translatable
import org.bukkit.event.Listener

interface Tweak : Listener {
    val plugin: MoreTweaks
        get() = MoreTweaks.getPlugin()

    val id: String

    val prettyName: String
        get() {
            return Translatable.getString("tweak.$id.name")
        }

    val description: String
        get() {
            return Translatable.getString("tweak.$id.description")
        }

    fun enable() {}
    fun disable() {}
    fun reload() {}

    fun requiredCustomListeners(): List<Class<out Listener>> = emptyList()
}