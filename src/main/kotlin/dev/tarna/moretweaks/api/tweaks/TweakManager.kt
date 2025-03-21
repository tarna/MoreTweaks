package dev.tarna.moretweaks.api.tweaks

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.utils.ReflectionUtils
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener

class TweakManager(val plugin: MoreTweaks) {
    val configManager = plugin.configManager

    val tweaks = mutableListOf<Tweak>()
    val enabledTweaks = mutableListOf<Tweak>()
    val disabledTweaks: List<Tweak>
        get() = tweaks - enabledTweaks.toSet()

    fun register(vararg tweaks: Tweak) {
        this.tweaks.addAll(tweaks)
    }

    fun unregister(vararg tweaks: Tweak) {
        this.tweaks.removeAll(tweaks.toSet())
    }

    fun getTweak(id: String): Tweak? {
        return tweaks.find { it.id == id }
    }

    fun isTweakEnabled(tweak: Tweak): Boolean {
        return enabledTweaks.contains(tweak)
    }

    fun getRequiredCustomListeners(): Set<Listener> {
        return tweaks
            .flatMap { it.requiredCustomListeners() }
            .map { it.getDeclaredConstructor().newInstance() }
            .toSet()
    }

    fun load() {
        val classes = ReflectionUtils.getClassesOfType<Tweak>("dev.tarna.moretweaks.tweaks")
        for (tweak in classes) {
            register(tweak)
            if (configManager.isTweakEnabled(tweak.id)) {
                enable(tweak)
            }
        }
        plugin.logger.info("Loaded ${tweaks.size} tweaks")
    }

    fun enable(tweak: Tweak) {
        if (enabledTweaks.contains(tweak)) return
        enabledTweaks.add(tweak)
        tweak.reload()
        tweak.enable()
        plugin.server.pluginManager.registerEvents(tweak, plugin)
        configManager.setTweakEnabled(tweak.id, true)
        plugin.logger.info("Enabled tweak: ${tweak.prettyName}")
    }

    fun disable(tweak: Tweak) {
        if (!enabledTweaks.contains(tweak)) return
        enabledTweaks.remove(tweak)
        tweak.disable()
        HandlerList.unregisterAll(tweak)
        configManager.setTweakEnabled(tweak.id, false)
        plugin.logger.info("Disabled tweak: ${tweak.prettyName}")
    }

    fun toggle(tweak: Tweak) {
        if (isTweakEnabled(tweak)) {
            disable(tweak)
        } else {
            enable(tweak)
        }
    }

    fun reloadAll() {
        enabledTweaks.forEach { it.reload() }
    }
}