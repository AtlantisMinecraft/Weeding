package net.atlantis.weeding.item

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object WeedingItem {
    private val totalName = ChatColor.RESET.toString() + ChatColor.YELLOW.toString() + "Totem of Weeding"

    fun totem(): ItemStack {
        val itemStack = ItemStack(Material.TOTEM)
        val itemMeta = itemStack.itemMeta
        itemMeta.displayName = totalName
        itemMeta.lore = listOf(ChatColor.RESET.toString() + "右クリックで除草することができます")
        itemStack.itemMeta = itemMeta
        return itemStack
    }

    fun isWeedingTotem(itemStack: ItemStack): Boolean {
        return itemStack.itemMeta.displayName == totalName && itemStack.type == Material.TOTEM
    }

}