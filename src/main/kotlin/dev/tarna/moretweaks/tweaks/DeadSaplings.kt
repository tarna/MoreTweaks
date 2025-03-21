package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.DeadSaplingsConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.isSapling
import dev.tarna.moretweaks.api.utils.toTicks
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.scheduler.BukkitRunnable
import java.time.Duration

class DeadSaplings : Tweak {
    override val id = "dead_saplings"

    private lateinit var delay: Duration
    private lateinit var time: Duration
    private lateinit var blocks: List<Material>

    private var deadSaplingsRunnable: DeadSaplingsRunnable? = null
    private val saplings = mutableMapOf<Location, Long>()

    override fun reload() {
        delay = DeadSaplingsConfig.delay
        time = DeadSaplingsConfig.time
        blocks = DeadSaplingsConfig.blocks

        disable()
        enable()
    }

    override fun enable() {
        deadSaplingsRunnable = DeadSaplingsRunnable()
        deadSaplingsRunnable?.runTaskTimer(plugin, 0, delay.toTicks())
    }

    override fun disable() {
        saplings.clear()
        deadSaplingsRunnable?.cancel()
        deadSaplingsRunnable = null
    }

    @EventHandler
    fun onSaplingPlace(event: PlayerInteractEvent) {
        if (!event.action.isRightClick) return

        val item = event.item ?: return
        val block = event.clickedBlock ?: return
        if (!blocks.contains(block.type)) return
        if (!item.isSapling) return

        val aboveBlock = block.getRelative(0, 1, 0)
        aboveBlock.type = item.type
        item.amount--
        saplings[aboveBlock.location] = System.currentTimeMillis()
    }

    @EventHandler
    fun onSaplingBreak(event: BlockBreakEvent) {
        val block = event.block
        if (!block.isSapling) return

        val location = block.location
        if (saplings.containsKey(location)) {
            saplings.remove(location)
        }
    }

    inner class DeadSaplingsRunnable : BukkitRunnable() {
        override fun run() {
            saplings.entries.removeIf { (location, saplingTime) ->
                if (System.currentTimeMillis() - saplingTime > time.toMillis()) {
                    location.block.type = Material.DEAD_BUSH
                    return@removeIf true
                }
                false
            }
        }
    }
}