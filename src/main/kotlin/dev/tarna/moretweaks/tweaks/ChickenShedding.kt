package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.ChickenSheddingConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.chance
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.entity.Chicken
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityDropItemEvent

class ChickenShedding : Tweak {
    override val id = "chicken_shedding"

    private lateinit var chance: Number
    private lateinit var drop: Material
    private lateinit var amount: Number

    override fun reload() {
        chance = ChickenSheddingConfig.chance
        drop = ChickenSheddingConfig.drop
        amount = ChickenSheddingConfig.amount
    }

    @EventHandler(ignoreCancelled = true)
    fun onChickenLay(event: EntityDropItemEvent) {
        val chicken = event.entity as? Chicken ?: return
        if (!chance(chance)) return

        event.isCancelled = true
        val location = chicken.location
        location.world.dropItem(location, drop.toItemStack(amount.toInt()))
    }
}