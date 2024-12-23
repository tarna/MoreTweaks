package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.ShapedRecipe

class CraftableEnchantedGoldenApple : CustomRecipe("craftable_enchanted_golden_apple") {
    override fun registerRecipes() = listOf(
        ShapedRecipe(key, Material.ENCHANTED_GOLDEN_APPLE.toItemStack())
            .shape(
                "GGG",
                "GAG",
                "GGG"
            )
            .setIngredient('G', Material.GOLD_BLOCK)
            .setIngredient('A', Material.APPLE)
    )
}