package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.DeathBookConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.mm
import dev.tarna.moretweaks.api.utils.not
import dev.tarna.moretweaks.api.utils.placeholder
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BookMeta
import java.util.UUID
import kotlin.math.roundToInt

class DeathBook : Tweak {
    override val id = "death_book"

    private lateinit var author: String
    private lateinit var title: String
    private lateinit var content: List<String>

    override fun reload() {
        author = DeathBookConfig.author
        title = DeathBookConfig.title
        content = DeathBookConfig.content
    }

    private val deathLocations = mutableMapOf<UUID, Location>()

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val player = event.player
        deathLocations[player.uniqueId] = player.location
    }

    @EventHandler
    fun onPlayerRespawn(event: PlayerRespawnEvent) {
        val player = event.player
        val location = deathLocations[player.uniqueId] ?: return

        val book = ItemStack(Material.WRITTEN_BOOK)
        val meta = book.itemMeta as BookMeta
        meta.author(!author)
        meta.title(!title)
        meta.addPages(
            mm.deserialize(content.joinToString("\n"),
                placeholder("x", location.x.roundToInt().toString()),
                placeholder("y", location.y.roundToInt().toString()),
                placeholder("z", location.z.roundToInt().toString()),
                placeholder("player", player.name)
            )
        )
        book.itemMeta = meta
        player.inventory.addItem(book)
        deathLocations.remove(player.uniqueId)
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        deathLocations.remove(event.player.uniqueId)
    }
}