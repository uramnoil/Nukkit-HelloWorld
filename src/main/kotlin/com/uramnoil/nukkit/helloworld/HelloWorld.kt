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

    fun sendMessage(player: Player, times: Int = 0, message: String = "Hello, World") {
        val job = GlobalScope.launch {
            repeat(times) {
                delay(1000L)
                player.sendMessage(message)
            }
        }
    }
}