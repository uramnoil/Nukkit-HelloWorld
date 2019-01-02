package com.uramnoil.nukkit.helloworld

import cn.nukkit.Player
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HelloWorldController : IHelloWorldController {
    override fun sendMessage(player: Player, times: Int, message: String) {
        GlobalScope.launch {
            repeat(times) {
                delay(1000L)
                player.sendMessage(message)
            }
        }
    }
}