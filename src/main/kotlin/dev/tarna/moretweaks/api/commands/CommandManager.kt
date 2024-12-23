package dev.tarna.moretweaks.api.commands

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.utils.ReflectionUtils

class CommandManager(val plugin: MoreTweaks) {
    val commands = mutableMapOf<String, CustomCommand>()

    fun register(vararg commands: CustomCommand) {
        commands.forEach { command ->
            command.register()
            this.commands[command.command] = command
            plugin.logger.info("Registered command: ${command.command}")
        }
    }

    fun unregister(vararg commands: CustomCommand) {
        commands.forEach { command ->
            command.unregister()
            this.commands.remove(command.command)
            plugin.logger.info("Unregistered command: ${command.command}")
        }
    }

    fun load() {
        val classes = ReflectionUtils.getCommandClasses<CustomCommand>("dev.tarna.moretweaks.commands")
        classes.forEach { command ->
            register(command)
        }
    }
}