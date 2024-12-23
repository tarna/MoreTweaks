package dev.tarna.moretweaks.api.utils

import dev.tarna.moretweaks.MoreTweaks
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.metadata.Metadatable
import org.bukkit.persistence.PersistentDataHolder
import org.bukkit.persistence.PersistentDataType

fun <T : Any> PersistentDataHolder.setValue(key: String, value: T, type: PersistentDataType<*, T>) {
    persistentDataContainer.set(Key.get(key), type, value)
}

fun <T> PersistentDataHolder.getValue(key: String, type: PersistentDataType<*, T>): T? {
    return persistentDataContainer.get(Key.get(key), type)
}

fun PersistentDataHolder.deleteValue(key: String) {
    persistentDataContainer.remove(Key.get(key))
}

fun <T : Any> Metadatable.setValue(key: String, value: T) {
    setMetadata(key, FixedMetadataValue(MoreTweaks.getPlugin(), value))
}

fun <T> Metadatable.getValue(key: String): T? {
    return getMetadata(key).firstOrNull()?.value() as? T
}