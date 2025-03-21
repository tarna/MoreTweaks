package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.XPBottlingConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.*
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.persistence.PersistentDataType

class XPBottling : Tweak {
    override val id = "xp_bottling"

    private lateinit var expPerBottle: Number

    override fun reload() {
        expPerBottle = XPBottlingConfig.expPerBottle
    }

    @EventHandler
    fun onRightClickTable(event: PlayerInteractEvent) {
        if (!event.action.isRightClick) return
        val block = event.clickedBlock ?: return
        if (block.type != Material.ENCHANTING_TABLE) return

        val item = event.item ?: return
        if (item.type != Material.GLASS_BOTTLE) return
        event.isCancelled = true

        val expPerBottle = expPerBottle.toInt()

        val player = event.player
        val exp = player.calculateTotalExperiencePoints()
        if (exp < expPerBottle) return

        player.setExperienceLevelAndProgress(exp - expPerBottle)
        val bottle = Material.EXPERIENCE_BOTTLE.toItemStack()
        bottle.setValue("xp", expPerBottle, PersistentDataType.INTEGER)
        bottle.setName("+${expPerBottle} XP")
        player.giveOrDrop(bottle)
        item.amount--
    }

    @EventHandler
    fun onRightClickBottle(event: PlayerInteractEvent) {
        if (!event.action.isRightClick) return
        val item = event.item ?: return
        if (item.type != Material.EXPERIENCE_BOTTLE) return

        val exp = item.getValue("xp", PersistentDataType.INTEGER) ?: return
        event.player.giveExp(exp)
        item.amount--
        event.isCancelled = true
    }
}