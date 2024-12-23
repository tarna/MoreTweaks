package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.config.objects.tweaks.AntiCreeperGriefConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import org.bukkit.entity.Creeper
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityExplodeEvent
import kotlin.properties.Delegates

class AntiCreeperGrief : Tweak {
    override val id = "anti_creeper_grief"

    private var doBlockDamage by Delegates.notNull<Boolean>()
    private var doEntityDamage by Delegates.notNull<Boolean>()

    override fun reload() {
        doBlockDamage = AntiCreeperGriefConfig.doBlockDamage
        doEntityDamage = AntiCreeperGriefConfig.doEntityDamage
    }

    @EventHandler
    fun onCreeperExplode(event: EntityExplodeEvent) {
        if (event.entity !is Creeper) return
        if (!doBlockDamage) event.blockList().clear()
    }

    @EventHandler
    fun onCreeperDamage(event: EntityDamageEvent) {
        if (event.entity !is Creeper) return
        if (!doEntityDamage) event.isCancelled = true
    }
}