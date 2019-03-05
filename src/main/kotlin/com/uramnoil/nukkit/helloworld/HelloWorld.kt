package com.uramnoil.nukkit.helloworld

import cn.nukkit.Player
import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import cn.nukkit.plugin.PluginBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HelloWorld : PluginBase(), Listener {
    lateinit var message: String
    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
        message = "Hello, World"
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        sendMessage(player, 10) {
            message
        }
    }

    fun sendMessage(player: Player, times: Int, proc: () -> String ) = GlobalScope.launch {
        repeat(times) {
            delay(1000L)
            player.sendMessage(proc())
        }
    }
}