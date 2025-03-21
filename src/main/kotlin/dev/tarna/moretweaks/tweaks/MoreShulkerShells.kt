package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.MoreShulkerShellsConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.entity.Shulker
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityDeathEvent

class MoreShulkerShells : Tweak {
    override val id = "more_shulker_shells"

    private lateinit var amount: Number

    override fun reload() {
        amount = MoreShulkerShellsConfig.amount
    }

    @EventHandler(ignoreCancelled = true)
    fun onShulkerDeath(event: EntityDeathEvent) {
        if (event.entity !is Shulker) return
        event.drops.clear()
        val newDrops = Material.SHULKER_SHELL.toItemStack(amount.toInt())
        event.drops.add(newDrops)
    }
}