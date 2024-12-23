package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.config.objects.recipes.BlastedOreBlocksConfig
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.Key
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.BlastingRecipe

class BlastedOreBlocks : CustomRecipe("blasted_ore_blocks") {
    private lateinit var experience: Number
    private lateinit var cookingTime: Number

    override fun reload() {
        experience = BlastedOreBlocksConfig.experience
        cookingTime = BlastedOreBlocksConfig.cookingTime
    }

    override fun registerRecipes() = listOf(
        createRecipe(Material.RAW_IRON_BLOCK, Material.IRON_BLOCK),
        createRecipe(Material.RAW_COPPER_BLOCK, Material.COPPER_BLOCK),
        createRecipe(Material.RAW_GOLD_BLOCK, Material.GOLD_BLOCK)
    )

    private fun createRecipe(input: Material, output: Material): BlastingRecipe {
        return BlastingRecipe(Key.get("${path}_${input.name}"), output.toItemStack(), input, experience.toFloat(), cookingTime.toInt())
    }
}