package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object UnlockAllRecipesConfig {
    var enabled by BooleanOption("tweaks.unlock_all_recipes.enabled", false)
}