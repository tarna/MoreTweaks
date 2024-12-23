package dev.tarna.moretweaks.api.utils

import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

fun Inventory.sort() {
    val items = contents.filterNotNull().groupBy { it.type }.flatMap { (type, items) ->
        val totalAmount = items.sumOf { it.amount }
        val fullStacks = totalAmount / type.maxStackSize
        val remainder = totalAmount % type.maxStackSize
        List(fullStacks) { ItemStack(type, type.maxStackSize) } + if (remainder > 0) listOf(ItemStack(type, remainder)) else emptyList()
    }.sortedBy { it.type.name }
    clear()
    items.forEachIndexed { index, item ->
        setItem(index, item)
    }
}