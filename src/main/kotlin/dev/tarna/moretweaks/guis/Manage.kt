package dev.tarna.moretweaks.guis

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.utils.not
import me.tech.mcchestui.GUI
import me.tech.mcchestui.GUIType
import me.tech.mcchestui.item.item
import me.tech.mcchestui.utils.gui
import me.tech.mcchestui.utils.openGUI
import org.bukkit.Material

fun manageGUI(): GUI {
    return gui(MoreTweaks.getPlugin(), !"<red><bold>MoreTweaks", GUIType.Chest(3)) {
        fill(1, 1, 9, 3) {
            item = item(Material.GRAY_STAINED_GLASS_PANE) {
                name = !" "
            }
        }

        slot(4, 2) {
            item = item(Material.BOOK) {
                name = !"<blue>Tweaks"
                lore = !listOf(
                    "<gray>Click to manage tweaks"
                )
            }

            onClick {
                it.openGUI(tweakListGUI())
            }
        }

        slot(6, 2) {
            item = item(Material.CRAFTING_TABLE) {
                name = !"<blue>Recipes"
                lore = !listOf(
                    "<gray>Click to manage recipes"
                )
            }

            onClick {
                it.openGUI(recipeListGUI())
            }
        }
    }
}