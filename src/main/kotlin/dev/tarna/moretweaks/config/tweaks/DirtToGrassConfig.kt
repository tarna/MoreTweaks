package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object DirtToGrassConfig {
    var enabled by BooleanOption("tweaks.dirt_to_grass.enabled", false)
    var wheatSeedChance by IntOption("tweaks.dirt_to_grass.wheat_seed_chance", 5)
    var melonSeedChance by IntOption("tweaks.dirt_to_grass.melon_seed_chance", 5)
    var pumpkinSeedChance by IntOption("tweaks.dirt_to_grass.pumpkin_seed_chance", 5)
    var beetrootSeedChance by IntOption("tweaks.dirt_to_grass.beetroot_seed_chance", 5)
    var boneMealChance by IntOption("tweaks.dirt_to_grass.bone_meal_chance", 20)
}