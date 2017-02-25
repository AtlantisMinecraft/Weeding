package net.atlantis.weeding.item

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WeedingItem {
    companion object Factory {
        val TOTEM_NAME = ChatColor.RESET.toString() + ChatColor.YELLOW.toString() + "Totem of Weeding"

        fun totem(): ItemStack {
            val itemStack = ItemStack(Material.TOTEM)
            val itemMeta = itemStack.itemMeta
            itemMeta.displayName = TOTEM_NAME
            itemMeta.lore = listOf(ChatColor.RESET.toString() + "右クリックで除草することができます")
            itemStack.itemMeta = itemMeta
            return itemStack
        }

        fun isWeedingTotem(itemStack: ItemStack): Boolean {
            return itemStack.itemMeta.displayName == TOTEM_NAME && itemStack.type == Material.TOTEM
        }
    }
}