package org.dojo.tictacto.api

import org.dojo.tictacto.domain.Player
import org.dojo.tictacto.domain.Tictacto

object TictactoView {

    fun viewPlayingPosition(player: Player, position: Int) {
        println("")
        println("--------------------------")
        println("")
        println("Player ${player.name} with symbol ${player.symbol} is playing position $position")
        println("")
    }

    fun viewBoard(board: Array<String>) {
        println(" ${board[0]} | ${board[1]} | ${board[2]} ")
        println("---+---+---")
        println(" ${board[3]} | ${board[4]} | ${board[5]} ")
        println("---+---+---")
        println(" ${board[6]} | ${board[7]} | ${board[8]} ")
    }

    fun viewResult(result: Tictacto.Result) {
        println("")
        if (result.winner != null) {
            println("Player ${result.winner.name} with symbol ${result.winner.symbol} wins!")
        } else if (result.draw) {
            println("Draw!")
        }
    }
}