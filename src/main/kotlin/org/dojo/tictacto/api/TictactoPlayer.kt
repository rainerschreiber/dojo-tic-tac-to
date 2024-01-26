package org.dojo.tictacto.api

import mu.KotlinLogging
import org.dojo.tictacto.api.TictactoView.viewBoard
import org.dojo.tictacto.api.TictactoView.viewPlayingPosition
import org.dojo.tictacto.api.TictactoView.viewResult
import org.dojo.tictacto.domain.Player
import org.dojo.tictacto.domain.Tictacto
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class TictactoPlayer {

    private val logger = KotlinLogging.logger {}

    /**
     * playTicTacTo
     *
     * This method is called when the application has started.
     * It creates two bot players that will be playing against each other.
     * They will randomly pick a position on the board and play it.
     * Sometimes one of them will win, sometimes they will draw.
     * During each play, the board and results are printed to the console.
     *
     */
    @EventListener(ApplicationReadyEvent::class)
    fun playTicTacTo() {
        logger.info { "Starting Tic-tac-to game" }

        val player1 = Player("Foo", "X")
        val player2 = Player("Bar", "O")
        var currentPlayer = player1

        val tictacto = Tictacto(player1, player2)
        var result: Tictacto.Result? = null

        val positions = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        while (result == null && positions.isNotEmpty()) {
            val position = positions.random()
            positions.remove(position)

            viewPlayingPosition(currentPlayer, position)

            result = tictacto.play(position, currentPlayer)
            printBoard(tictacto.board, result)

            currentPlayer = if (currentPlayer == player1) player2 else player1

            Thread.sleep(500)
        }
    }

    private fun printBoard(board: Array<String>, result: Tictacto.Result?) {
        viewBoard(board)
        if (result != null) {
            viewResult(result)
        }
    }

}