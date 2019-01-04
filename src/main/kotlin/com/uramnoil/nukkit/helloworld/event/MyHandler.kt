package com.uramnoil.nukkit.helloworld.event

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import com.uramnoil.nukkit.helloworld.IHelloWorld

class MyHandler(private val helloworld: IHelloWorld) : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        helloworld.sendMessage(event.player, 10, "Hello, World")
    }
}