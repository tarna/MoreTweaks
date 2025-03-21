package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.config.objects.recipes.UnpackableIceConfig
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.Key.toKey
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.ShapelessRecipe

class UnpackableIce : CustomRecipe("unpackable_ice") {
    private lateinit var amount: Number

    override fun reload() {
        amount = UnpackableIceConfig.amount
    }

    override fun registerRecipes(): List<Recipe> {
        return listOf(
            createRecipe(Material.PACKED_ICE, Material.ICE),
            createRecipe(Material.BLUE_ICE, Material.PACKED_ICE)
        )
    }

    private fun createRecipe(material: Material, result: Material): Recipe {
        return ShapelessRecipe("unpackable_${material.name.lowercase()}".toKey(), result.toItemStack(amount))
            .addIngredient(material)
    }
}