package dev.tarna.moretweaks.config.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.EntityTypeListOption
import org.bukkit.entity.EntityType

object TransferablePetsConfig {
    var enabled by BooleanOption("tweaks.transferable_pets.enabled", false)
    var pets by EntityTypeListOption("tweaks.transferable_pets.pet",
        listOf(
            EntityType.HORSE,
            EntityType.CAMEL,
            EntityType.CAT,
            EntityType.DONKEY,
            EntityType.LLAMA,
            EntityType.MULE,
            EntityType.PARROT,
            EntityType.WOLF
        )
    )
}