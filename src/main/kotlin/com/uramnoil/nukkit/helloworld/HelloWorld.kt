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
        player.sendMessageRepeating(10, 1000L) {
            message
        }
    }

    fun Player.sendMessageRepeating(times: Int, delay: Long, proc: () -> String ) = GlobalScope.launch {
        repeat(times) {
            delay(delay)
            sendMessage(proc())
        }
    }
}