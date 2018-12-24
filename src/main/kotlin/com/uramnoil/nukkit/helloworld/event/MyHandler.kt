package com.uramnoil.nukkit.helloworld.event

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerJoinEvent
import com.uramnoil.nukkit.helloworld.HelloWorld

class MyHandler(private val plugin: HelloWorld) : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        plugin.sendMessage(event.player)
    }
}