package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.ShapedRecipe

class StickyHoneyPiston : CustomRecipe("sticky_honey_piston") {
    override fun registerRecipes() = listOf(
        ShapedRecipe(key, Material.STICKY_PISTON.toItemStack())
            .shape(
                "H",
                "P"
            )
            .setIngredient('H', Material.HONEYCOMB)
            .setIngredient('P', Material.PISTON)
    )
}