package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.allWool
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.ShapelessRecipe

class UnpackableWool : CustomRecipe("unpackable_wool") {
    override fun registerRecipes() = listOf(
        ShapelessRecipe(key, Material.STRING.toItemStack(4))
            .addIngredient(RecipeChoice.MaterialChoice(allWool))
    )
}