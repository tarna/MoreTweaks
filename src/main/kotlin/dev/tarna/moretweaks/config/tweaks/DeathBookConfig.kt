package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.StringListOption
import dev.tarna.moretweaks.api.config.options.impl.StringOption

object DeathBookConfig {
    var enabled by BooleanOption("tweaks.book_death.enabled", false)
    var author by StringOption("tweaks.book_death.author", "MoreTweaks")
    var title by StringOption("tweaks.book_death.title", "Death Location")
    var content by StringListOption("tweaks.book_death.content", listOf(
        "<red><bold>Death Coordinates",
        "",
        "<red><italic>RIP, you died at:",
        "",
        "    <black>X: <red><x>",
        "    <black>Y: <red><y>",
        "    <black>Z: <red><z>",
        "",
        "<red>Good luck finding your stuff!"
    ))
}