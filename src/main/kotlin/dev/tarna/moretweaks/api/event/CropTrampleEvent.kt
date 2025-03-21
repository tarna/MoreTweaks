package dev.tarna.moretweaks.api.event

import org.bukkit.block.Block
import org.bukkit.entity.Entity
import org.bukkit.event.Cancellable
import org.bukkit.event.HandlerList
import org.bukkit.event.entity.EntityEvent

class CropTrampleEvent(entity: Entity, val cause: TrampleCause, val block: Block) : EntityEvent(entity), Cancellable {
    private var cancelled = false

    companion object {
        @JvmStatic
        val HANDLERS = HandlerList()

        @JvmStatic
        fun getHandlerList(): HandlerList {
            return HANDLERS
        }
    }

    override fun getHandlers(): HandlerList {
        return HANDLERS
    }

    override fun isCancelled(): Boolean {
        return cancelled
    }

    override fun setCancelled(cancelled: Boolean) {
        this.cancelled = cancelled
    }

    enum class TrampleCause {
        MOB,
        PLAYER
    }
}