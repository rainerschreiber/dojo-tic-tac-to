package org.dojo.tictacto.domain

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class TictactoGetPlayedPositionsTest {

    private val testPlayer = Player("Test player", "X")
    private val theOtherPlayer = Player("The other player", "O")
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

    @Test
    fun `Should return empty list if player has not played any position`() {
        val tictacto = Tictacto()
        assertThat(tictacto.getPlayedPositions(testPlayer)).isEmpty()
    }

    @Test
    fun `Should return the positions of all winning combinations played by the player`() {
        winningCombinations.forEach { combination ->
            val tictacto = Tictacto()
            combination.forEach { position ->
                tictacto.play(position, testPlayer)
            }
            val playedPositions = tictacto.getPlayedPositions(testPlayer)
            assertThat(playedPositions).hasSize(combination.size)
            assertThat(playedPositions).containsAll(combination)
        }
    }

    @Test
    fun `Should return 0 positions when the played positions are requested for the other player`() {
        winningCombinations.forEach { combination ->
            val tictacto = Tictacto()
            combination.forEach { position ->
                tictacto.play(position, testPlayer)
            }
            val playedPositions = tictacto.getPlayedPositions(theOtherPlayer)
            assertThat(playedPositions).hasSize(0)
        }
    }

}