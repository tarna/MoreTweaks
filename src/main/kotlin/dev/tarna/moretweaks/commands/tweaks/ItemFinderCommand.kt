package dev.tarna.moretweaks.commands.tweaks

import dev.tarna.moretweaks.api.commands.CustomCommand
import dev.tarna.moretweaks.api.commands.TweakCommand
import dev.tarna.moretweaks.api.lang.Translatable
import dev.tarna.moretweaks.config.tweaks.ItemFinderConfig
import dev.tarna.moretweaks.api.utils.getNearbyContainers
import dev.tarna.moretweaks.api.utils.placeholder
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class ItemFinderCommand(command: String) : CustomCommand(command), TweakCommand {
    override val playerOnly = true

    override fun execute(player: Player, args: Array<String>) {
        val range = ItemFinderConfig.range
        val nearbyContainers = player.location.getNearbyContainers(range)

        val item = Material.matchMaterial(args[0]) ?: run {
            player.sendMessage(Translatable.get("tweak.item_finder.invalid_item", placeholder("item", args[0])))
            return
        }

        val locations = nearbyContainers.filter { container ->
            container.inventory.contents.any { it?.type == item }
        }.map { it.location }

        locations.forEach { location ->
            object : BukkitRunnable() {
                private var ticks = 0
                override fun run() {
                    if (ticks++ >= 100) {
                        cancel()
                        return
                    }
                    player.spawnParticle(Particle.HAPPY_VILLAGER, location.clone().add(0.5, 1.0, 0.5), 10)
                }
            }.runTaskTimer(plugin, 0, 1)
        }
    }

    override fun tabComplete(sender: CommandSender, args: Array<String>): MutableList<String> {
        val items = Material.entries.map { it.name.lowercase() }
        return items
            .filter { it.startsWith(args[0].lowercase()) }
            .toMutableList()
    }

    override fun getPermission() = ItemFinderConfig.permission
}