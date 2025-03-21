package dev.tarna.moretweaks.api.config.options.impl

import dev.tarna.moretweaks.api.config.options.ConfigOption

class MessageTypeOption(val path: String, val default: MessageTypeOption.MessageType) : ConfigOption<MessageTypeOption.MessageType>() {
    override fun get(): MessageType {
        return when (config.getString(path) ?: return default) {
            "action_bar" -> MessageType.ACTION_BAR
            "chat" -> MessageType.CHAT
            "title" -> MessageType.TITLE
            else -> MessageType.ACTION_BAR
        }
    }

    override fun set(value: MessageType) {
        config.set(path, value.name.lowercase())
        config.save(file)
    }

    enum class MessageType {
        ACTION_BAR,
        CHAT,
        TITLE;
    }
}