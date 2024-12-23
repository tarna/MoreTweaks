package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.dropItemWithoutVelocity
import dev.tarna.moretweaks.api.utils.isCauldron
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent

class SlimeCream : Tweak {
    override val id = "slime_cream"

    @EventHandler
    fun onRightClick(event: PlayerInteractEvent) {
        if (!event.action.isRightClick) return
        val item = event.item ?: return
        if (item.type != Material.SLIME_BALL && item.type != Material.MAGMA_CREAM) return

        val block = event.clickedBlock ?: return
        if (!block.isCauldron) return

        if (item.type == Material.SLIME_BALL && block.type == Material.LAVA_CAULDRON) {
            drop(block.location, Material.MAGMA_CREAM)
        } else if (item.type == Material.MAGMA_CREAM && block.type == Material.WATER_CAULDRON) {
            drop(block.location, Material.SLIME_BALL)
        } else return

        item.amount--
    }

    private fun drop(location: Location, item: Material) {
        location.world.dropItemWithoutVelocity(location.add(0.5, 1.0, 0.5), item.toItemStack(), false)
    }
}