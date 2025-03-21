package dev.tarna.moretweaks.tweaks

import dev.tarna.moretweaks.config.tweaks.PetMemorialNameTagConfig
import dev.tarna.moretweaks.api.tweaks.Tweak
import dev.tarna.moretweaks.api.utils.*
import io.papermc.paper.event.entity.TameableDeathMessageEvent
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.EntityCombustEvent
import org.bukkit.event.inventory.PrepareAnvilEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import kotlin.properties.Delegates

class PetMemorialNameTag : Tweak {
    override val id = "pet_memorial_name_tag"

    private lateinit var drop: Material
    private lateinit var chance: Number
    private lateinit var format: String
    private var showDeathMessage by Delegates.notNull<Boolean>()
    private var shouldBurn by Delegates.notNull<Boolean>()

    override fun reload() {
        drop = PetMemorialNameTagConfig.drop
        chance = PetMemorialNameTagConfig.chance
        format = PetMemorialNameTagConfig.format
        showDeathMessage = PetMemorialNameTagConfig.showDeathMessage
        shouldBurn = PetMemorialNameTagConfig.shouldBurn
    }

    @EventHandler
    fun onPetDeath(event: TameableDeathMessageEvent) {
        val pet = event.entity
        val petName = pet.customName()?.rawString() ?: return

        if (chance(chance)) {
            val nametag = drop.toItemStack()
            nametag.setName(format.replace("<name>", petName))
            nametag.setValue("pet_memorial", true, PersistentDataType.BOOLEAN)
            nametag.setValue("death_message", event.deathMessage().rawString(), PersistentDataType.STRING)

            pet.world.dropItemWithoutVelocity(pet.location, nametag)
        }
    }

    @EventHandler
    fun onRightClick(event: PlayerInteractEvent) {
        val item = event.item ?: return
        if (!isMemorialNametag(item)) return
        val deathMessage = item.getValue("death_message", PersistentDataType.STRING) ?: return

        event.player.sendMessage(deathMessage)
    }

    @EventHandler
    fun onAnvilUse(event: PrepareAnvilEvent) {
        val anvilInventory = event.inventory

        val firstItem = anvilInventory.firstItem
        val secondItem = anvilInventory.secondItem

       if (isMemorialNametag(firstItem) || isMemorialNametag(secondItem)) {
            event.result = null
       }
    }

    @EventHandler
    fun itemBurn(event: EntityCombustEvent) {
        val item = event.entity as? ItemStack ?: return
        if (isMemorialNametag(item)) {
            event.isCancelled = !shouldBurn
        }
    }

    private fun isMemorialNametag(item: ItemStack?): Boolean {
        return item != null && item.hasValue("pet_memorial", PersistentDataType.BOOLEAN)
    }
}