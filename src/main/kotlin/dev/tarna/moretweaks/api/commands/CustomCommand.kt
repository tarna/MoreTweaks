package dev.tarna.moretweaks.api.commands

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.utils.send
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.SimpleCommandMap
import org.bukkit.entity.Player

abstract class CustomCommand(val command: String) : Command(command) {
    val plugin = MoreTweaks.getPlugin()
    open val playerOnly = false

    override fun execute(sender: CommandSender, label: String, args: Array<String>): Boolean {
        if (playerOnly && sender !is Player) {
            sender.send("<red>This command can only be executed by players.")
            return true
        }
        if (sender is Player && playerOnly) {
            execute(sender, args)
        } else {
            execute(sender, args)
        }
        return true
    }

    override fun tabComplete(sender: CommandSender, label: String, args: Array<String>): MutableList<String> {
        return tabComplete(sender, args)
    }

    open fun execute(sender: CommandSender, args: Array<String>) {}
    open fun execute(player: Player, args: Array<String>) {}

    open fun tabComplete(sender: CommandSender, args: Array<String>) = mutableListOf<String>()

    fun register() {
        val commandMap = plugin.server.commandMap as SimpleCommandMap
        commandMap.register(command, plugin.name, this)
        Bukkit.getOnlinePlayers().forEach(Player::updateCommands)
    }

    fun unregister() {
        val commandMap = plugin.server.commandMap as SimpleCommandMap
        commandMap.knownCommands.remove(command)
        Bukkit.getOnlinePlayers().forEach(Player::updateCommands)
    }
}