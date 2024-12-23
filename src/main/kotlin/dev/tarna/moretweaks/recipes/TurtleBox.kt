package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.ShapedRecipe

class TurtleBox : CustomRecipe("turtle_box") {
    override fun registerRecipes() = listOf(
        ShapedRecipe(key, Material.GREEN_SHULKER_BOX.toItemStack())
            .shape(
                " T ",
                " C ",
                " T "
            )
            .setIngredient('T', Material.TURTLE_HELMET)
            .setIngredient('C', Material.CHEST)
    )
}