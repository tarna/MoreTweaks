package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.config.recipes.UnpackableNetherWartConfig
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.ShapelessRecipe

class UnpackableNetherWart : CustomRecipe("unpackable_nether_wart") {
    private lateinit var amount: Number

    override fun reload() {
        amount = UnpackableNetherWartConfig.amount
    }

    override fun registerRecipes() = listOf(
        ShapelessRecipe(key, Material.NETHER_WART.toItemStack(amount))
            .addIngredient(Material.NETHER_WART_BLOCK)
    )
}