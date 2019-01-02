package com.uramnoil.nukkit.helloworld

import cn.nukkit.plugin.PluginBase
import com.uramnoil.nukkit.helloworld.event.MyHandler

class HelloWorld : PluginBase() {
    private val controller = HelloWorldController()
    private val handler = MyHandler(controller)
    override fun onEnable() {
        server.pluginManager.registerEvents(handler, this)
    }
}