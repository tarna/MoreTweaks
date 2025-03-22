package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption

object ZombiePickaxeConfig {
    var enabled by BooleanOption("tweaks.zombie_pickaxe.enabled", false)
    var yLevel by IntOption("tweaks.zombie_pickaxe.y_level", 50)
    var noneChance by IntOption("tweaks.zombie_pickaxe.chances.none", 50)
    var woodenPickaxeChance by IntOption("tweaks.zombie_pickaxe.chances.wooden_pickaxe", 20)
    var stonePickaxeChance by IntOption("tweaks.zombie_pickaxe.chances.stone_pickaxe", 10)
    var ironPickaxeChance by IntOption("tweaks.zombie_pickaxe.chances.iron_pickaxe", 5)
    var goldenPickaxeChance by IntOption("tweaks.zombie_pickaxe.chances.golden_pickaxe", 5)
    var diamondPickaxeChance by IntOption("tweaks.zombie_pickaxe.chances.diamond_pickaxe", 5)
    var netheritePickaxeChance by IntOption("tweaks.zombie_pickaxe.chances.netherite_pickaxe", 5)
}