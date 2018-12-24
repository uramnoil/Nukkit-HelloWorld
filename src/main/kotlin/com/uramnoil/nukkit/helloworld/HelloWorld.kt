package com.uramnoil.nukkit.helloworld

import cn.nukkit.Player
import cn.nukkit.plugin.PluginBase
import com.uramnoil.nukkit.helloworld.event.MyHandler
import kotlinx.coroutines.*

class HelloWorld : PluginBase() {
    override fun onEnable() {
        val handler = MyHandler(this)
        server.pluginManager.registerEvents(handler, this)
    }

    fun sendMessage(player: Player, message: String = "Hello, World") = GlobalScope.launch {
        for(i in 1..10) {
            delay(1000L)
            player.sendMessage(message)
        }
    }
}