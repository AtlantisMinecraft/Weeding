package net.atlantis.weeding

import net.atlantis.weeding.command.WeedingCommand
import net.atlantis.weeding.listener.WeedingListener
import org.bukkit.plugin.java.JavaPlugin

class Weeding : JavaPlugin() {

    override fun onEnable() {
        WeedingListener(this)
        getCommand("weeding").executor = WeedingCommand(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
