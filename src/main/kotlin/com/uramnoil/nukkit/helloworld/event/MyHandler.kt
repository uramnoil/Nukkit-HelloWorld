package com.uramnoil.nukkit.helloworld.event

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import com.uramnoil.nukkit.helloworld.IHelloWorld

class MyHandler(private val presentator: IHelloWorld) : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        presentator.sendMessage(event.player, 10, "Hello, World")
    }
}