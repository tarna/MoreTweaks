package dev.tarna.moretweaks.commands

import dev.tarna.moretweaks.api.commands.CustomCommand
import dev.tarna.moretweaks.api.utils.send
import dev.tarna.moretweaks.guis.manageGUI
import me.tech.mcchestui.utils.openGUI
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class MoreTweaksCommand : CustomCommand("moretweaks") {
    override fun execute(sender: CommandSender, args: Array<String>) {
        if (args.isEmpty()) {
            sendHelp(sender)
            return
        }

        if (args[0].equals("reload", true)) {
            plugin.reloadConfig()
            plugin.tweakManager.reloadAll()
            plugin.recipeManager.reloadAll()
            sender.send("<green>Reloaded config, tweaks and recipes.")
            return
        }

        if (args[0].equals("tweaks", true)) {
            if (args.size < 3) {
                sender.send("<red>Usage: /moretweaks tweaks <enable|disable> <tweak>")
                return
            }

            val tweak = plugin.tweakManager.getTweak(args[2])
            if (tweak == null) {
                sender.send("<red>Unknown tweak: ${args[2]}")
                return
            }

            if (args[1].equals("enable", true)) {
                plugin.tweakManager.enable(tweak)
                sender.send("<green>Enabled tweak: ${tweak.prettyName}")
            } else if (args[1].equals("disable", true)) {
                plugin.tweakManager.disable(tweak)
                sender.send("<green>Disabled tweak: ${tweak.prettyName}")
            } else {
                sender.send("<red>Usage: /moretweaks tweaks <enable|disable> <tweak>")
            }
            return
        }

        if (args[0].equals("recipes", true)) {
            if (args.size < 3) {
                sender.send("<red>Usage: /moretweaks recipes <enable|disable> <recipe>")
                return
            }

            val recipe = plugin.recipeManager.getRecipe(args[2])
            if (recipe == null) {
                sender.send("<red>Unknown recipe: ${args[2]}")
                return
            }

            if (args[1].equals("enable", true)) {
                plugin.recipeManager.enable(recipe)
                sender.send("<green>Enabled recipe: ${recipe.name}")
            } else if (args[1].equals("disable", true)) {
                plugin.recipeManager.disable(recipe)
                sender.send("<green>Disabled recipe: ${recipe.name}")
            } else {
                sender.send("<red>Usage: /moretweaks recipes <enable|disable> <recipe>")
            }
            return
        }

        if (args[0].equals("manage", true)) {
            if (sender !is Player) {
                sender.send("<red>Only players can use this command.")
                return
            }

            sender.openGUI(manageGUI())
            return
        }

        sendHelp(sender)
    }

    private fun sendHelp(sender: CommandSender) {
        sender.send("<blue><bold>MoreTweaks Help:")
        sender.send("<green>  /moretweaks reload")
        sender.send("<green>  /moretweaks tweaks <enable|disable> <tweak>")
        sender.send("<green>  /moretweaks recipes <enable|disable> <recipe>")
        sender.send("<green>  /moretweaks manage")
    }

    override fun tabComplete(sender: CommandSender, args: Array<String>): MutableList<String> {
        if (args.size == 1) {
            return listOf("reload", "tweaks", "recipes", "manage")
                .filter { it.startsWith(args[0], true) }
                .toMutableList()
        }

        if (args.size == 2) {
            return listOf("enable", "disable")
                .filter { it.startsWith(args[1], true) }
                .toMutableList()
        }

        if (args.size == 3) {
            if (args[0].equals("tweaks", true)) {
                if (args[1].equals("enable", true)) {
                    return plugin.tweakManager.disabledTweaks.map { it.id }
                        .filter { it.startsWith(args[2], true) }
                        .toMutableList()
                } else if (args[1].equals("disable", true)) {
                    return plugin.tweakManager.enabledTweaks.map { it.id }
                        .filter { it.startsWith(args[2], true) }
                        .toMutableList()
                }
            }

            if (args[0].equals("recipes", true)) {
                if (args[1].equals("enable", true)) {
                    return plugin.recipeManager.disabledRecipes.map { it.path }
                        .filter { it.startsWith(args[2], true) }
                        .toMutableList()
                } else if (args[1].equals("disable", true)) {
                    return plugin.recipeManager.enabledRecipes.map { it.path }
                        .filter { it.startsWith(args[2], true) }
                        .toMutableList()
                }
            }
        }

        return mutableListOf()
    }

    override fun getPermission(): String {
        return "moretweaks.admin"
    }
}