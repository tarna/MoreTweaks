package dev.tarna.moretweaks.api.utils

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer

val mm = MiniMessage.miniMessage()

operator fun String.not() = mm.deserialize(this)

operator fun List<String>.not() = map { !it }

operator fun Array<String>.not(): Array<Component> = map { !it }.toTypedArray()

fun Component.rawString() = LegacyComponentSerializer.legacySection().serialize(this)

fun placeholder(key: String, value: String): TagResolver.Single {
    return Placeholder.component(key, !value)
}