package dev.tarna.moretweaks.api.utils

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.Container

val allLogs = listOf(
    Material.OAK_LOG,
    Material.SPRUCE_LOG,
    Material.BIRCH_LOG,
    Material.JUNGLE_LOG,
    Material.ACACIA_LOG,
    Material.DARK_OAK_LOG,
    Material.MANGROVE_LOG,
    Material.CHERRY_LOG,
    Material.CRIMSON_STEM,
    Material.WARPED_STEM
)

val allPlanks = listOf(
    Material.OAK_PLANKS,
    Material.SPRUCE_PLANKS,
    Material.BIRCH_PLANKS,
    Material.JUNGLE_PLANKS,
    Material.ACACIA_PLANKS,
    Material.DARK_OAK_PLANKS,
    Material.MANGROVE_PLANKS,
    Material.CHERRY_PLANKS,
    Material.CRIMSON_PLANKS,
    Material.WARPED_PLANKS
)

val allWool = listOf(
    Material.WHITE_WOOL,
    Material.ORANGE_WOOL,
    Material.MAGENTA_WOOL,
    Material.LIGHT_BLUE_WOOL,
    Material.YELLOW_WOOL,
    Material.LIME_WOOL,
    Material.PINK_WOOL,
    Material.GRAY_WOOL,
    Material.LIGHT_GRAY_WOOL,
    Material.CYAN_WOOL,
    Material.PURPLE_WOOL,
    Material.BLUE_WOOL,
    Material.BROWN_WOOL,
    Material.GREEN_WOOL,
    Material.RED_WOOL,
    Material.BLACK_WOOL
)

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