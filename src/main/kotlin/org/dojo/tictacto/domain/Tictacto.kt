package org.dojo.tictacto.domain

class Tictacto {

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

    fun play(position: Int, player: Player) {
        require(position in 1..9) { "Position must be between 1 and 9" }
        require(board[position - 1] == " ") { "Position $position is already played" }
        board[position - 1] = player.symbol
    }

    fun getPlayedPositions(player: Player): List<Int> {
        return board.mapIndexedNotNull { index, value ->
            if (value != " " && value == player.symbol) index + 1 else null
        }
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
