package com.uramnoil.nukkit.helloworld

import cn.nukkit.Player
import cn.nukkit.plugin.PluginBase
import com.uramnoil.nukkit.helloworld.event.MyHandler
import kotlinx.coroutines.*

class HelloWorld : PluginBase(), IHelloWorld {
    override fun onEnable() {
        val handler = MyHandler(this)
        server.pluginManager.registerEvents(handler, this)
    }

    override fun sendMessage(player: Player, times: Int, message: String) {
        GlobalScope.launch {
            repeat(times) {
                delay(1000L)
                player.sendMessage(message)
            }
        }
    }
}