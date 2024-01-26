package org.dojo.tictacto.domain

/**
 * EA Sports. It's in the game :)
 *
 * Tic Tac To game
 *
 * Rules:
 *
 * 1. The board is a 3x3 grid, where each position is numbered from 1 to 9, from top left to bottom right
 *
 *  1 | 2 | 3
 * ---+---+---
 *  4 | 5 | 6
 * ---+---+---
 *  7 | 8 | 9
 *
 * 2. There are two players in the game (X and O symbols)
 * 3. Players take turns by playing their symbol at a certain empty position until the game is over
 * 3. The first player to get 3 of their symbols in a row (up, down, across, or diagonally) is the winner
 * 4. When all 9 squares are full, and there is no winner, the game ends in a draw
 *
 *
 * @param player1 the first player
 * @param player2 the second player
 * @property board the board
 * @property winningCombinations the winning combinations
 * @property currentPlayer the current player
 * @property isGameFinished true if the game is finished, false otherwise
 * @constructor Creates a new Tictacto game
 * @throws IllegalArgumentException if the player is not the current player
 * @throws IllegalArgumentException if the position is not between 1 and 9
 * @throws IllegalArgumentException if the position is already played
 *
 */
class Tictacto(
    val player1: Player,
    val player2: Player
) {

    data class Result(val winner: Player?, val draw: Boolean)

    // init the board starting state
    var board = arrayOf(" ", " ", " ", " ", " ", " ", " ", " ", " ")
        private set
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
    private var currentPlayer: Player = player1
    private var isGameFinished = false

    /**
     * Play a position for a player
     *
     * @param position the position to play
     * @param player the player
     */
    fun play(position: Int, player: Player): Result? {
        require(!isGameFinished) { "Game is already finished" }
        require(player == currentPlayer) { "It must be player's turn" }
        require(position in 1..9) { "Position must be between 1 and 9" }
        require(board[position - 1] == " ") { "Position $position is already played" }
        board[position - 1] = player.symbol
        currentPlayer = if (currentPlayer == player1) player2 else player1

        if (isWinner(player)) {
            isGameFinished = true
            return Result(player, false)
        }
        if (getAllPlayedPositions().size == 9) {
            isGameFinished = true
            return Result(null, true)
        }
        return null
    }

    /**
     * Check if a player is the winner
     *
     * @param player the player
     * @return true if the player is the winner, false otherwise
     */
    private fun isWinner(player: Player): Boolean {
        return winningCombinations.any { combination ->
            combination.all { position ->
                board[position - 1] == player.symbol
            }
        }
    }

    /**
     * Get all played positions
     *
     * @return the list of all played positions
     */
    private fun getAllPlayedPositions(): List<Int> {
        return board.mapIndexedNotNull { index, value ->
            if (value != " ") index + 1 else null
        }
    }

}
