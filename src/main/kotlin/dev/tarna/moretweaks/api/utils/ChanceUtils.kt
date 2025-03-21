package dev.tarna.moretweaks.api.utils

fun chance(percentage: Int) = percentage == 100 || (0..100).random() <= percentage
fun chance(percentage: Number) = chance(percentage.toInt())

fun <T> weightedChance(vararg chances: Pair<T, Int>): T {
    val total = chances.sumOf { it.second }
    val random = (0 until total).random()
    var current = 0
    for ((item, chance) in chances) {
        current += chance
        if (random < current) return item
    }
    return chances.last().first
}

fun <T> weightedChance(chances: Map<T, Int>): T {
    val total = chances.values.sum()
    val random = (0 until total).random()
    var current = 0
    for ((item, chance) in chances) {
        current += chance
        if (random < current) return item
    }
    return chances.entries.last().key
}