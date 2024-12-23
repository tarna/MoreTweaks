package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption

object UnlockAllRecipesConfig {
    var enabled by BooleanOption("tweaks.unlock_all_recipes.enabled", false)
}