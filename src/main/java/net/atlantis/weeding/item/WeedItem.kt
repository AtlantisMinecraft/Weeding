package net.atlantis.weeding.item

import org.bukkit.Material
import org.bukkit.block.Block

object WeedItem {
    private val weedItems = listOf(Material.LONG_GRASS, Material.DOUBLE_PLANT, Material.YELLOW_FLOWER, Material.RED_ROSE)

    fun isWeedItem(block: Block): Boolean {
        return weedItems.contains(block.type)
    }
}