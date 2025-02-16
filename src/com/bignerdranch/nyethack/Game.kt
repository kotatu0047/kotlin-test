package com.bignerdranch.nyethack

fun main(args: Array<String>) {
    val player = Player(_name = "Madrigal", healthPoints = 1, isBlessed = true, isImmortal = false)
    player.castFireball()

    printPlayerStatus(player)
}

private fun printPlayerStatus(
    player: Player
) {
    println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}
