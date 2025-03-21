package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.RealTimeClockConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.commands.tweaks.RealTimeClockCommand

class RealTimeClock : Tweak {
    override val id = "real_time_clock"

    private lateinit var commandName: String

    override fun reload() {
        commandName = RealTimeClockConfig.command
    }

    override fun enable() {
        plugin.commandManager.register(RealTimeClockCommand(commandName))
    }

    override fun disable() {
        plugin.commandManager.unregister(RealTimeClockCommand(commandName))
    }
}