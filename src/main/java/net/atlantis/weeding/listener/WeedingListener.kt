package net.atlantis.weeding.listener

import net.atlantis.weeding.Weeding
import net.atlantis.weeding.item.WeedItem
import net.atlantis.weeding.item.WeedingItem
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class WeedingListener(private val plugin: Weeding) : Listener {

    init {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    @EventHandler
    fun onClick(event: PlayerInteractEvent) {
        if (event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK) {
            val player = event.player
            val itemStack = player.inventory.itemInMainHand
            var count = 0
            if (WeedingItem.isWeedingTotem(itemStack)) {
                val hash: Set<Material>? = null
                val targetLocation = player.getTargetBlock(hash, 100).location
                val range = 5
                for (x in -range..range) {
                    for (y in -range..range) {
                        for (z in -range..range) {
                            val targetX = (targetLocation.x + x).toInt()
                            val targetY = (targetLocation.y + y).toInt()
                            val targetZ = (targetLocation.z + z).toInt()
                            val block = player.world.getBlockAt(targetX, targetY, targetZ)
                            if (weeding(block)) {
                                count += 1
                            }
                        }
                    }
                }
                if (count > 0) {
                    player.playSound(player.location, Sound.ENTITY_ENDERMEN_TELEPORT, 3.0f, 0.533f)
                }
                player.sendMessage("[" + ChatColor.AQUA.toString() + ChatColor.BOLD.toString() + "Weeding" + ChatColor.RESET.toString() + "] $count 個除草しました")
            }
        }
    }

    private fun weeding(block: Block): Boolean = if (WeedItem.isWeedItem(block)) {
        block.type = Material.AIR
        block.world.spawnParticle(Particle.LAVA, block.location, 2)
        true
    } else {
        false
    }

}