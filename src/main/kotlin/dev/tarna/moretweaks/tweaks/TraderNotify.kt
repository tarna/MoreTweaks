package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.TraderNotifyConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.mm
import dev.tarna.moretweaks.api.utils.placeholder
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.sound.Sound
import org.bukkit.Bukkit
import org.bukkit.entity.WanderingTrader
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.CreatureSpawnEvent
import kotlin.properties.Delegates

class TraderNotify : Tweak {
    override val id = "trader_notify"

    private lateinit var message: String
    private var playSound by Delegates.notNull<Boolean>()
    private lateinit var sound: Sound
    private lateinit var radius: Number

    override fun reload() {
        message = TraderNotifyConfig.message
        playSound = TraderNotifyConfig.playSound
        sound = TraderNotifyConfig.sound
        radius = TraderNotifyConfig.radius
    }

    @EventHandler
    fun onWanderingTraderSpawn(event: CreatureSpawnEvent) {
        val entity = event.entity
        if (entity !is WanderingTrader) return

        val location = entity.location

        if (playSound) {
            val players = location.getNearbyPlayers(radius.toDouble())
            val audience = Audience.audience(players)
            audience.playSound(sound, location.x, location.y, location.z)
        }

        val formattedMessage = mm.deserialize(message,
            placeholder("x", location.x.toString()),
            placeholder("y", location.y.toString()),
            placeholder("z", location.z.toString())
        )
        Bukkit.broadcast(formattedMessage)
    }
}