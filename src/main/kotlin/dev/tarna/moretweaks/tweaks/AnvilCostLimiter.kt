package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.AnvilCostLimiterConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.PrepareAnvilEvent

class AnvilCostLimiter : Tweak {
    override val id = "anvil_cost_limiter"

    private lateinit var limit: Number

    override fun reload() {
        limit = AnvilCostLimiterConfig.limit
    }

    @Suppress("UnstableApiUsage")
    @EventHandler
    fun onAnvilPrepare(event: PrepareAnvilEvent) {
        val anvil = event.view
        val cost = anvil.maximumRepairCost
        val limit = limit.toInt()
        if (cost > limit) {
            anvil.maximumRepairCost = limit
        }
    }
}