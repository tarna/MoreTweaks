package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.config.objects.recipes.StickyHoneyPistonConfig
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.ShapedRecipe

class StickyHoneyPiston : CustomRecipe("sticky_honey_piston") {
    private lateinit var amount: Number

    override fun reload() {
        amount = StickyHoneyPistonConfig.amount
    }

    override fun registerRecipes() = listOf(
        ShapedRecipe(key, Material.STICKY_PISTON.toItemStack(amount))
            .shape(
                "H",
                "P"
            )
            .setIngredient('H', Material.HONEYCOMB)
            .setIngredient('P', Material.PISTON)
    )
}