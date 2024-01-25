package org.dojo.tictacto.domain

class Tictacto(
    val player1: Player,
    val player2: Player
) {

    val board = arrayOf(" ", " ", " ", " ", " ", " ", " ", " ", " ")
    private val winningCombinations = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9),
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(3, 6, 9),
        listOf(1, 5, 9),
        listOf(3, 5, 7)
    )

    // initiate player 1 as the first (current) player
    private var currentPlayer: Player = player1

    fun play(position: Int, player: Player) {
        require(player == currentPlayer) { "It must be player's turn" }
        require(position in 1..9) { "Position must be between 1 and 9" }
        require(board[position - 1] == " ") { "Position $position is already played" }
        board[position - 1] = player.symbol
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }

    fun getAllPlayedPositions(): List<Int> {
        return board.mapIndexedNotNull { index, value ->
            if (value != " ") index + 1 else null
        }
    }

    fun isWinner(player: Player): Boolean {
        return winningCombinations.any { combination ->
            combination.all { position ->
                board[position - 1] == player.symbol
            }
        }
    }

}
