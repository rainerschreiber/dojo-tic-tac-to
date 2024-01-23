package org.dojo.tictacto.domain

class Tictacto {

    val board = arrayOf(" ", " ", " ", " ", " ", " ", " ", " ", " ")

    fun play(position: Int, player: Player) {
        require(position in 1..9) { "Position must be between 1 and 9" }
        require(board[position - 1] == " ") { "Position $position is already played" }
        board[position - 1] = player.symbol
    }


}
