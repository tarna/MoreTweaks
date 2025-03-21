package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.MobsOnBlocksConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import io.papermc.paper.event.entity.EntityMoveEvent
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Cow
import org.bukkit.entity.Drowned
import org.bukkit.entity.Husk
import org.bukkit.entity.MushroomCow
import org.bukkit.event.EventHandler
import kotlin.properties.Delegates

class MobsOnBlocks : Tweak {
    override val id = "mobs_on_blocks"

    private var drowned by Delegates.notNull<Boolean>()
    private var mooshroom by Delegates.notNull<Boolean>()
    private var cow by Delegates.notNull<Boolean>()

    override fun reload() {
        drowned = MobsOnBlocksConfig.drowned
        mooshroom = MobsOnBlocksConfig.mooshroom
        cow = MobsOnBlocksConfig.cow
    }

    @EventHandler
    fun onEntityMove(event: EntityMoveEvent) {
        val block = event.to.block.getRelative(0, -1, 0)
        when (val entity = event.entity) {
            is Drowned -> drowned(block, entity)
            is MushroomCow -> mooshroom(block)
            is Cow -> cow(block, entity)
        }
    }

    private fun drowned(block: Block, drowned: Drowned) {
        if (!this.drowned) return
        if (block.type != Material.SPONGE) return
        block.type = Material.WET_SPONGE
        drowned.remove()
        block.world.spawn(drowned.location, Husk::class.java)
    }

    private fun mooshroom(block: Block) {
        if (!mooshroom) return
        if (block.type != Material.PODZOL) return
        block.type = Material.MYCELIUM
    }

    private fun cow(block: Block, cow: Cow) {
        if (!this.cow) return
        val blocks = listOf(
            Material.RED_MUSHROOM_BLOCK,
            Material.BROWN_MUSHROOM_BLOCK,
            Material.MUSHROOM_STEM,
            Material.MYCELIUM
        )
        if (!blocks.contains(block.type)) return
        block.type = Material.DIRT
        cow.remove()
        block.world.spawn(cow.location, MushroomCow::class.java)
    }
}