package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.toItemStack
import dev.tarna.moretweaks.api.utils.weightedChance
import dev.tarna.moretweaks.config.tweaks.ZombiePickaxeConfig
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntitySpawnEvent

class ZombiePickaxe : Tweak {
    override val id = "zombie_pickaxe"

    private lateinit var pickaxeChances: Map<Material, Int>

    override fun reload() {
        pickaxeChances = mapOf(
            Material.AIR to ZombiePickaxeConfig.noneChance,
            Material.WOODEN_PICKAXE to ZombiePickaxeConfig.woodenPickaxeChance,
            Material.STONE_PICKAXE to ZombiePickaxeConfig.stonePickaxeChance,
            Material.IRON_PICKAXE to ZombiePickaxeConfig.ironPickaxeChance,
            Material.GOLDEN_PICKAXE to ZombiePickaxeConfig.goldenPickaxeChance,
            Material.DIAMOND_PICKAXE to ZombiePickaxeConfig.diamondPickaxeChance,
            Material.NETHERITE_PICKAXE to ZombiePickaxeConfig.netheritePickaxeChance
        )
    }

    @EventHandler
    fun onZombieSpawn(event: EntitySpawnEvent) {
        val entity = event.entity as? LivingEntity ?: return
        if (entity.type != EntityType.ZOMBIE) return
        if (entity.location.y > ZombiePickaxeConfig.yLevel) return
        val pickaxe = weightedChance(pickaxeChances)
        if (pickaxe == Material.AIR) return
        entity.equipment?.setItemInMainHand(pickaxe.toItemStack())
    }
}