package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption
import dev.tarna.moretweaks.api.config.options.impl.MaterialOption
import dev.tarna.moretweaks.api.config.options.impl.StringOption
import org.bukkit.Material

object PetMemorialNameTagConfig {
    var enabled by BooleanOption("tweaks.pet_memorial_name_tag.enabled", false)
    var drop by MaterialOption("tweaks.pet_memorial_name_tag.drop", Material.NAME_TAG)
    var chance by IntOption("tweaks.pet_memorial_name_tag.chance", 100)
    var format by StringOption("tweaks.pet_memorial_name_tag.format", "<red><bold>In Memory of <white><name>")
    var showDeathMessage by BooleanOption("tweaks.pet_memorial_name_tag.show_death_message", true)
    var shouldBurn by BooleanOption("tweaks.pet_memorial_name_tag.should_burn", false)
}