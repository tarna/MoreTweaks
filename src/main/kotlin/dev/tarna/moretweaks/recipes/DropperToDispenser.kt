package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.config.recipes.DropperToDispenserConfig
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.ShapedRecipe

class DropperToDispenser : CustomRecipe("dropper_to_dispenser") {
    private lateinit var amount: Number

    override fun reload() {
        amount = DropperToDispenserConfig.amount
    }

    override fun registerRecipes() = listOf(
        ShapedRecipe(key, Material.DISPENSER.toItemStack(amount))
            .shape(
                " ST",
                "SDT",
                " ST"
            )
            .setIngredient('S', Material.STICK)
            .setIngredient('T', Material.STRING)
            .setIngredient('D', Material.DROPPER)
    )
}