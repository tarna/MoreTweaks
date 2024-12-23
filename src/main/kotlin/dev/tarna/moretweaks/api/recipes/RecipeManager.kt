package dev.tarna.moretweaks.api.recipes

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.utils.ReflectionUtils

class RecipeManager(val plugin: MoreTweaks) {
    val configManager = plugin.configManager

    val recipes = mutableListOf<CustomRecipe>()
    val enabledRecipes = mutableListOf<CustomRecipe>()
    val disabledRecipes: List<CustomRecipe>
        get() = recipes - enabledRecipes.toSet()

    fun register(vararg recipes: CustomRecipe) {
        this.recipes.addAll(recipes)
    }

    fun unregister(vararg recipes: CustomRecipe) {
        this.recipes.removeAll(recipes.toSet())
    }

    fun getRecipe(id: String): CustomRecipe? {
        return recipes.find { it.path == id }
    }

    fun isRecipeEnabled(recipe: CustomRecipe): Boolean {
        return enabledRecipes.contains(recipe)
    }

    fun load() {
        val recipes = ReflectionUtils.getClassesOfType<CustomRecipe>("dev.tarna.moretweaks.recipes")
        for (recipe in recipes) {
            register(recipe)
            if (configManager.isRecipeEnabled(recipe.path)) {
                enable(recipe)
            }
        }
        plugin.logger.info("Loaded ${recipes.size} recipes")
    }

    fun enable(recipe: CustomRecipe) {
        if (enabledRecipes.contains(recipe)) return
        enabledRecipes.add(recipe)
        recipe.reload()
        recipe.register()
        configManager.setRecipeEnabled(recipe.path, true)
        plugin.logger.info("Enabled recipe: ${recipe.name}")
    }

    fun disable(recipe: CustomRecipe) {
        if (!enabledRecipes.contains(recipe)) return
        enabledRecipes.remove(recipe)
        recipe.unregister()
        configManager.setRecipeEnabled(recipe.path, false)
        plugin.logger.info("Disabled recipe: ${recipe.name}")
    }

    fun toggle(recipe: CustomRecipe) {
        if (isRecipeEnabled(recipe)) {
            disable(recipe)
        } else {
            enable(recipe)
        }
    }

    fun reloadAll() {
        for (recipe in recipes) {
            if (isRecipeEnabled(recipe)) {
                recipe.reload()
                recipe.unregister()
                recipe.register()
            }
        }
    }
}