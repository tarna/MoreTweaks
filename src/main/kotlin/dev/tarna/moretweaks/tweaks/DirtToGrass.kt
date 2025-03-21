package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.DirtToGrassConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.chance
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent

class DirtToGrass : Tweak {
    override val id = "dirt_to_grass"

    private lateinit var wheatSeedChance: Number
    private lateinit var melonSeedChance: Number
    private lateinit var pumpkinSeedChance: Number
    private lateinit var beetrootSeedChance: Number
    private lateinit var boneMealChance: Number

    override fun reload() {
        wheatSeedChance = DirtToGrassConfig.wheatSeedChance
        melonSeedChance = DirtToGrassConfig.melonSeedChance
        pumpkinSeedChance = DirtToGrassConfig.pumpkinSeedChance
        beetrootSeedChance = DirtToGrassConfig.beetrootSeedChance
        boneMealChance = DirtToGrassConfig.boneMealChance
    }

    @EventHandler
    fun onClickGrass(event: PlayerInteractEvent) {
        if (!event.action.isRightClick) return

        val block = event.clickedBlock ?: return
        if (block.type != Material.DIRT) return

        val item = event.player.inventory.itemInMainHand
        val chance = when (item.type) {
            Material.WHEAT_SEEDS -> wheatSeedChance
            Material.MELON_SEEDS -> melonSeedChance
            Material.PUMPKIN_SEEDS -> pumpkinSeedChance
            Material.BEETROOT_SEEDS -> beetrootSeedChance
            Material.BONE_MEAL -> boneMealChance
            else -> return
        }

        item.amount--
        if (chance(chance)) {
            block.type = Material.GRASS_BLOCK
        }
    }
}