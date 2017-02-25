package net.atlantis.weeding.item

import org.bukkit.Material
import org.bukkit.block.Block

class WeedItem {
    companion object Factory {
        private val WEED_ITEMS = listOf(Material.LONG_GRASS, Material.DOUBLE_PLANT, Material.YELLOW_FLOWER, Material.RED_ROSE)

        fun isWeedItem(block: Block): Boolean {
            return WEED_ITEMS.contains(block.type)
        }
    }
}