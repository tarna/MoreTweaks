package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.IntOption

object RandomCreeperFuseConfig {
    var minFuse by IntOption("tweaks.random_creeper_fuse.min_fuse", 10)
    var maxFuse by IntOption("tweaks.random_creeper_fuse.max_fuse", 100)
}