package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.OneLifeOneTotemConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.deleteValue
import dev.tarna.moretweaks.api.utils.getValue
import dev.tarna.moretweaks.api.utils.setValue
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityResurrectEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.event.world.TimeSkipEvent
import org.bukkit.persistence.PersistentDataType
import kotlin.properties.Delegates

class OneLifeOneTotem : Tweak {
    override val id = "one_life_one_totem"

    private var sleepingResets by Delegates.notNull<Boolean>()

    override fun reload() {
        sleepingResets = OneLifeOneTotemConfig.sleepingResets
    }

    @EventHandler
    fun onTotemUse(event: EntityResurrectEvent) {
        if (event.hand == null) return

        val player = event.entity as? Player ?: return
        val hasUsed = player.getValue("used_totem", PersistentDataType.BOOLEAN) ?: false
        if (hasUsed) {
            event.isCancelled = true
            return
        }

        player.setValue("used_totem", true, PersistentDataType.BOOLEAN)
    }

    @EventHandler
    fun onRespawn(event: PlayerRespawnEvent) {
        event.player.deleteValue("used_totem")
    }

    @EventHandler
    fun onSleep(event: TimeSkipEvent) {
        if (!sleepingResets) return

        event.world.players
            .filter(Player::isSleeping)
            .forEach {
                it.setValue("used_totem", false, PersistentDataType.BOOLEAN)
            }
    }
}