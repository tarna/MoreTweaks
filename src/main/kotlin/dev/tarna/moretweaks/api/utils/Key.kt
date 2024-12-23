package dev.tarna.moretweaks.api.utils

import dev.tarna.moretweaks.MoreTweaks
import org.bukkit.NamespacedKey

object Key {
    fun get(key: String): NamespacedKey {
        return NamespacedKey(MoreTweaks.getPlugin(), key)
    }

    fun String.toKey(): NamespacedKey {
        return get(this)
    }
}