package com.uramnoil.nukkit.helloworld.event

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import com.uramnoil.nukkit.helloworld.IHelloWorldController

class MyHandler(private val controller: IHelloWorldController) : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        controller.sendMessage(event.player, 10, "Hello, World")
    }
}