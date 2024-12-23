package dev.tarna.moretweaks.commands.tweaks

import dev.tarna.moretweaks.api.commands.CustomCommand
import dev.tarna.moretweaks.api.commands.TweakCommand
import dev.tarna.moretweaks.api.config.objects.tweaks.RealTimeClockConfig
import dev.tarna.moretweaks.api.utils.mm
import dev.tarna.moretweaks.api.utils.placeholder
import org.bukkit.entity.Player

class RealTimeClockCommand(command: String) : CustomCommand(command), TweakCommand {
    override val playerOnly = true

    override fun execute(player: Player, args: Array<String>) {
        val world = player.world
        val time = world.gameTime
        val days = ((time / 20 / 60 / 60) / 24).toInt()
        val hours = (time / 20 / 60 / 60).toInt() % 24
        val minutes = (time / 20 / 60).toInt() % 60

        val message = RealTimeClockConfig.message
        player.sendMessage(mm.deserialize(message,
            placeholder("days", days.toString()),
            placeholder("hours", hours.toString()),
            placeholder("minutes", minutes.toString())
        ))
    }

    override fun getPermission() = RealTimeClockConfig.permission
}