package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.config.objects.recipes.UnpackableWoolConfig
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.allWool
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.ShapelessRecipe

class UnpackableWool : CustomRecipe("unpackable_wool") {
    private lateinit var amount: Number

    override fun reload() {
        amount = UnpackableWoolConfig.amount
    }

    override fun registerRecipes() = listOf(
        ShapelessRecipe(key, Material.STRING.toItemStack(amount))
            .addIngredient(RecipeChoice.MaterialChoice(allWool))
    )
}