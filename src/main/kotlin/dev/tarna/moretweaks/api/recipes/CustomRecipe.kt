package dev.tarna.moretweaks.api.recipes

import dev.tarna.moretweaks.api.lang.Translatable
import dev.tarna.moretweaks.api.utils.Key
import org.bukkit.Bukkit
import org.bukkit.Keyed
import org.bukkit.NamespacedKey
import org.bukkit.inventory.Recipe

abstract class CustomRecipe(val path: String) {
    var name: String
    var description: String

    var recipes = mutableListOf<Recipe>()

    init {
        val langKey = path.replace("-", "_")
        name = Translatable.getString("recipe.$langKey.name")
        description = Translatable.getString("recipe.$langKey.description")
    }

    val key: NamespacedKey by lazy {
        Key.get(path)
    }

    open fun reload() {}
    abstract fun registerRecipes(): List<Recipe>

    fun register() {
        for (recipe in registerRecipes()) {
            Bukkit.addRecipe(recipe, true)
            recipes.add(recipe)
        }
    }

    fun unregister() {
        for (recipe in recipes) {
            Bukkit.removeRecipe((recipe as Keyed).key, true)
        }
        recipes.clear()
    }

    fun isRegistered(): Boolean {
        return recipes.isNotEmpty()
    }
}