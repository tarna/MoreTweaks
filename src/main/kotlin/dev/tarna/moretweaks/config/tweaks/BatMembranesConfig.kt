package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialOption
import org.bukkit.Material

object BatMembranesConfig {
    var enabled by BooleanOption("tweaks.bat_membranes.enabled", false)
    var chance by IntOption("tweaks.bat_membranes.chance", 100)
    var drop by MaterialOption("tweaks.bat_membranes.drop", Material.PHANTOM_MEMBRANE)
    var amount by IntOption("tweaks.bat_membranes.amount", 1)
}