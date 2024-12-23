package dev.tarna.moretweaks.guis

import dev.tarna.moretweaks.MoreTweaks
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.not
import dev.tarna.moretweaks.api.utils.send
import me.tech.mcchestui.GUI
import me.tech.mcchestui.GUIType
import me.tech.mcchestui.item.item
import me.tech.mcchestui.utils.gui
import me.tech.mcchestui.utils.openGUI
import org.bukkit.Material

fun tweakListGUI(page: Int = 0, tweaks: List<Tweak>? = null): GUI {
    val plugin = MoreTweaks.getPlugin()
    val tweakManager = plugin.tweakManager
    val tweaks = tweaks ?: tweakManager.tweaks
    return gui(plugin, !"<red><bold>Tweaks (${tweaks.size})", GUIType.Chest(6)) {
        fillBorder {
            item = item(Material.GRAY_STAINED_GLASS_PANE) {
                name = !" "
            }
        }

        val pageSize = 28
        val start = page * pageSize
        val end = start + pageSize
        for (i in start until end) {
            val tweak = tweaks.getOrNull(i) ?: break
            nextAvailableSlot {
                item = item(Material.PAPER) {
                    name = !tweak.prettyName
                    lore = !listOf(
                        tweak.description,
                        "<green>Enabled: <white>${tweakManager.isTweakEnabled(tweak)}"
                    )
                }

                onClick {
                    tweakManager.toggle(tweak)
                    it.openGUI(tweakListGUI(page, tweaks))
                }
            }
        }

        if (end < tweaks.size) {
            slot(6, 6) {
                item = item(Material.ARROW) {
                    name = !"Next Page"
                }

                onClick {
                    it.openGUI(tweakListGUI(page + 1))
                }
            }
        }

        if (page > 0) {
            slot(4, 6) {
                item = item(Material.ARROW) {
                    name = !"Previous Page"
                }

                onClick {
                    it.openGUI(tweakListGUI(page - 1))
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
                tweakManager.reloadAll()
                it.openGUI(tweakListGUI(page, tweaks))
                it.send("<green>Reloaded all tweaks.")
            }
        }
    }
}