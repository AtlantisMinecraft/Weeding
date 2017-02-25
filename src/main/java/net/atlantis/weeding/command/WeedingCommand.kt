package net.atlantis.weeding.command

import net.atlantis.weeding.Weeding
import net.atlantis.weeding.item.WeedingItem
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class WeedingCommand(private val plugin: Weeding) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is Player) {
            val player = sender
            player.inventory.addItem(WeedingItem.totem())
            return true
        }
        return false
    }
}