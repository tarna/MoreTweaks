package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.Bukkit
import org.bukkit.Keyed
import org.bukkit.NamespacedKey
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent

class UnlockAllRecipes : Tweak {
    override val id = "unlock_all_recipes"

    private val allRecipes = mutableListOf<NamespacedKey>()

    override fun enable() {
        Bukkit.recipeIterator().forEach { recipe ->
            if (recipe is Keyed) {
                allRecipes.add(recipe.key)
            }
        }
    }

    override fun disable() {
        allRecipes.clear()
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.player.discoverRecipes(allRecipes)
    }
}