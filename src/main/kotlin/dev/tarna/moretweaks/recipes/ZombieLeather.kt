package dev.tarna.moretweaks.recipes

import dev.tarna.moretweaks.api.config.objects.recipes.ZombieLeatherConfig
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.toItemStack
import org.bukkit.Material
import org.bukkit.inventory.FurnaceRecipe

class ZombieLeather : CustomRecipe("zombie_leather") {
    private lateinit var experience: Number
    private lateinit var cookingTime: Number
    private lateinit var amount: Number

    override fun reload() {
        experience = ZombieLeatherConfig.experience
        cookingTime = ZombieLeatherConfig.cookingTime
        amount = ZombieLeatherConfig.amount
    }

    override fun registerRecipes() = listOf(
        FurnaceRecipe(
            key,
            Material.LEATHER.toItemStack(amount),
            Material.ROTTEN_FLESH,
            experience.toFloat(),
            cookingTime.toInt()
        )
    )
}