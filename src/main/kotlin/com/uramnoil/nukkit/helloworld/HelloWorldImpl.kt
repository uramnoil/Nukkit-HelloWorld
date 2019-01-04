package com.uramnoil.nukkit.helloworld

import cn.nukkit.Player
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HelloWorldImpl : IHelloWorld {
    override fun sendMessage(player: Player, times: Int, message: String) {
        GlobalScope.launch {
            repeat(times) {
                delay(1000L)
                player.sendMessage(message)
            }
        }
    }
}