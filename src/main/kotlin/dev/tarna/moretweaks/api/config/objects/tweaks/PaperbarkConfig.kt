package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialListOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialOption
import dev.tarna.moretweaks.api.utils.allLogs
import org.bukkit.Material

object PaperbarkConfig {
    var enabled by BooleanOption("tweaks.paperbark.enabled", false)
    var chance by IntOption("tweaks.paperbark.chance", 10)
    var drop by MaterialOption("tweaks.paperbark.drop", Material.PAPER)
    var amount by IntOption("tweaks.paperbark.amount", 1)
    var logs by MaterialListOption("tweaks.paperbark.logs", allLogs)
}