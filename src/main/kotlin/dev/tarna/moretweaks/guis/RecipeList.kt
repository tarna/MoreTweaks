package dev.tarna.moretweaks.guis

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.recipes.CustomRecipe
import dev.tarna.moretweaks.api.utils.not
import dev.tarna.moretweaks.api.utils.send
import me.tech.mcchestui.GUI
import me.tech.mcchestui.GUIType
import me.tech.mcchestui.item.item
import me.tech.mcchestui.utils.gui
import me.tech.mcchestui.utils.openGUI
import org.bukkit.Material

fun recipeListGUI(page: Int = 0, recipes: List<CustomRecipe>? =  null): GUI {
    val plugin = MoreTweaks.getPlugin()
    val recipeManager = plugin.recipeManager
    val recipes = recipes ?: recipeManager.recipes
    return gui(plugin, !"<red><bold>Recipes (${recipes.size})", GUIType.Chest(6)) {
        fillBorder {
            item = item(Material.GRAY_STAINED_GLASS_PANE) {
                name = !" "
            }
        }

        val pageSize = 28
        val start = page * pageSize
        val end = start + pageSize
        for (i in start until end) {
            val recipe = recipes.getOrNull(i) ?: break
            nextAvailableSlot {
                item = item(Material.PAPER) {
                    name = !recipe.name
                    lore = !listOf(
                        recipe.description,
                        "<green>Enabled: <white>${recipeManager.isRecipeEnabled(recipe)}"
                    )
                }

                onClick {
                    recipeManager.toggle(recipe)
                    it.openGUI(recipeListGUI(page, recipes))
                }
            }
        }

        if (end < recipes.size) {
            slot(6, 6) {
                item = item(Material.ARROW) {
                    name = !"Next Page"
                }

                onClick {
                    it.openGUI(recipeListGUI(page + 1))
                }
            }
        }

        if (page > 0) {
            slot(4, 6) {
                item = item(Material.ARROW) {
                    name = !"Previous Page"
                }

                onClick {
                    it.openGUI(recipeListGUI(page - 1))
                }
            }
        }

        slot(1, 6) {
            item = item(Material.OAK_DOOR) {
                name = !"<red>Back"
            }

            onClick {
                it.openGUI(manageGUI())
            }
        }

        slot(9, 6) {
            item = item(Material.REDSTONE_BLOCK) {
                name = !"<red>Reload All"
            }

            onClick {
                recipeManager.reloadAll()
                it.openGUI(recipeListGUI(page, recipes))
                it.send("<green>Reloaded all recipes.")
            }
        }
    }
}