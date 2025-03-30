package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.config.tweaks.FireAspectLighterConfig
import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.block.data.Lightable
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.TNTPrimed
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent
import kotlin.properties.Delegates

class FireAspectLighter : Tweak {
    override val id = "fire_aspect_lighter"

    private var campfire by Delegates.notNull<Boolean>()
    private var candle by Delegates.notNull<Boolean>()
    private var netherPortal by Delegates.notNull<Boolean>()
    private var tnt by Delegates.notNull<Boolean>()

    override fun reload() {
        campfire = FireAspectLighterConfig.campfire
        candle = FireAspectLighterConfig.candle
        netherPortal = FireAspectLighterConfig.netherPortal
        tnt = FireAspectLighterConfig.tnt
    }

    @EventHandler
    fun onUseFireAspect(event: PlayerInteractEvent) {
        if (!event.action.isLeftClick) return

        val block = event.clickedBlock ?: return
        val item = event.item ?: return
        if (!item.containsEnchantment(Enchantment.FIRE_ASPECT)) return

        when (block.type) {
            Material.CAMPFIRE, Material.CANDLE -> {
                if (!campfire && !candle) return
                val blockData = block.blockData as? Lightable ?: return
                if (blockData.isLit) return
                blockData.isLit = true
                block.blockData = blockData
            }
            Material.OBSIDIAN -> {
                if (!netherPortal) return
                val aboveBlock = block.getRelative(BlockFace.UP)
                if (aboveBlock.type != Material.AIR) return
                aboveBlock.type = Material.FIRE
            }
            Material.TNT -> {
                if (!tnt) return
                block.type = Material.AIR
                block.world.spawn(block.location.clone().add(0.5, 0.5, 0.5), TNTPrimed::class.java)
            }
            else -> return
        }
    }
}