package dev.tarna.moretweaks.api.utils

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.Container

val Block.isSapling: Boolean
    get() = type in allSaplings

val Block.isLog: Boolean
    get() = type in allLogs

val Block.isPlank: Boolean
    get() = type in allPlanks

val Block.isWool: Boolean
    get() = type in allWool

val Block.isFarmLand: Boolean
    get() = type in allFarmLandBlocks

fun Location.getNearbyBlocks(radius: Int): List<Block> {
    val blocks = mutableListOf<Block>()
    for (x in -radius..radius) {
        for (y in -radius..radius) {
            for (z in -radius..radius) {
                blocks.add(this.clone().add(x.toDouble(), y.toDouble(), z.toDouble()).block)
            }
        }
    }
    return blocks
}

fun Location.getNearbyBlocks(radius: Int, vararg types: Material): List<Block> {
    val blocks = mutableListOf<Block>()
    for (x in -radius..radius) {
        for (y in -radius..radius) {
            for (z in -radius..radius) {
                val block = this.clone().add(x.toDouble(), y.toDouble(), z.toDouble()).block
                if (block.type in types) blocks.add(block)
            }
        }
    }
    return blocks
}

fun Location.getNearbyContainers(radius: Int): List<Container> {
    val blocks = getNearbyBlocks(radius)
        .map { it.state }
    return blocks.filterIsInstance<Container>()
}