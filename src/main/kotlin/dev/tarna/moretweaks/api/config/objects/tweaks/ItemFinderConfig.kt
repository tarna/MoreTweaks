package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption
import dev.tarna.moretweaks.api.config.options.impl.StringOption

object ItemFinderConfig {
    var enabled by BooleanOption("tweaks.item_finder.enabled", false)
    var command by StringOption("tweaks.item_finder.command", "finditem")
    var permission by StringOption("tweaks.item_finder.permission", "moretweaks.itemfinder")
    var range by IntOption("tweaks.item_finder.range", 5)
}