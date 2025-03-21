package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.config.recipes.CraftableBellConfig
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.allPlanks
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.ShapedRecipe

class CraftableBell : CustomRecipe("craftable_bell") {
    private lateinit var amount: Number

    override fun reload() {
        amount = CraftableBellConfig.amount
    }

    override fun registerRecipes() = listOf(
        ShapedRecipe(key, Material.BELL.toItemStack(amount))
            .shape(
                "PPP",
                " B ",
                "INI"
            )
            .setIngredient('P', RecipeChoice.MaterialChoice(allPlanks))
            .setIngredient('B', Material.GOLD_BLOCK)
            .setIngredient('I', Material.GOLD_INGOT)
            .setIngredient('N', Material.GOLD_NUGGET)
    )
}