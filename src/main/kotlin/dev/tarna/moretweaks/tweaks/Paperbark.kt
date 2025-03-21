package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.PaperbarkConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.chance
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class Paperbark : Tweak {
    override val id = "paperbark"

    private lateinit var chance: Number
    private lateinit var drop: Material
    private lateinit var amount: Number
    private lateinit var logs: List<Material>

    override fun reload() {
        chance = PaperbarkConfig.chance
        drop = PaperbarkConfig.drop
        amount = PaperbarkConfig.amount
        logs = PaperbarkConfig.logs
    }

    @EventHandler(ignoreCancelled = true)
    fun onLogStrip(event: PlayerInteractEvent) {
        val action = event.action
        if (action != Action.RIGHT_CLICK_BLOCK) return

        val block = event.clickedBlock ?: return
        if (!logs.contains(block.type)) return

        if (!chance(chance)) return
        val location = block.location
        location.world.dropItemNaturally(location, drop.toItemStack(amount))
    }
}