package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialOption
import org.bukkit.Material

object ChickenSheddingConfig {
    var enabled by BooleanOption("tweaks.chicken_shedding.enabled", false)
    var chance by IntOption("tweaks.chicken_shedding.chance", 10)
    var drop by MaterialOption("tweaks.chicken_shedding.drop", Material.FEATHER)
    var amount by IntOption("tweaks.chicken_shedding.amount", 1)
}