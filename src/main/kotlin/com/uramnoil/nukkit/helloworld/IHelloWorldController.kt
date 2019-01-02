package com.uramnoil.nukkit.helloworld

import cn.nukkit.Player

interface IHelloWorldController {
    fun sendMessage(player: Player, times: Int = 0, message: String = "Hello, World")
}