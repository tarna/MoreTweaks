package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.DurabilityPingConfig
import dev.tarna.moretweaks.api.config.options.impl.MessageTypeOption
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.send
import net.kyori.adventure.sound.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerItemDamageEvent
import org.bukkit.inventory.meta.Damageable

class DurabilityPing : Tweak {
    override val id = "durability_ping"

    private lateinit var threshold: Number
    private lateinit var messageType: MessageTypeOption.MessageType
    private lateinit var message: String
    private lateinit var sound: Sound

    override fun reload() {
        threshold = DurabilityPingConfig.threshold
        messageType = DurabilityPingConfig.messageType
        message = DurabilityPingConfig.message
        sound = DurabilityPingConfig.sound
    }

    @EventHandler
    fun onItemDamage(event: PlayerItemDamageEvent) {
        val item = event.item
        val meta = item.itemMeta as? Damageable ?: return
        val maxDurability = item.type.maxDurability
        val durability = maxDurability - meta.damage
        val percentage = (durability / maxDurability.toDouble()) * 100
        if (percentage <= threshold.toDouble()) {
            val player = event.player
            player.send(messageType, message)
            player.playSound(sound)
        }
    }
}