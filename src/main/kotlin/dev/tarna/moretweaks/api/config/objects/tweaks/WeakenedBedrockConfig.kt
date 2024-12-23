package dev.tarna.moretweaks.api.config.objects.tweaks

import dev.tarna.moretweaks.api.config.options.impl.BooleanOption
import dev.tarna.moretweaks.api.config.options.impl.IntOption
import dev.tarna.moretweaks.api.config.options.impl.WorldListOption

object WeakenedBedrockConfig {
    var enabled by BooleanOption("tweaks.weakened_bedrock.enabled", false)
    var radius by IntOption("tweaks.weakened_bedrock.radius", 3)
    var chance by IntOption("tweaks.weakened_bedrock.chance", 50)
    var speed by IntOption("tweaks.weakened_bedrock.speed", 10)
    var worlds by WorldListOption("tweaks.weakened_bedrock.worlds", emptyList())
}