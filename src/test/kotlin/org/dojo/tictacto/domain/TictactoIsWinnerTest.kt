package org.dojo.tictacto.domain

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class TictactoIsWinnerTest {

    private val testPlayer = Player("Test player", "X")
    private val winningCombinations = listOf(
        listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9), listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9),
        listOf(1, 5, 9), listOf(3, 5, 7)
    )
    private val nonWinningCombinations = listOf(
        listOf(1, 2), listOf(1, 3), listOf(1, 4), listOf(1, 5), listOf(1, 6), listOf(1, 7), listOf(1, 8), listOf(1, 9),
        listOf(2, 3), listOf(2, 4), listOf(2, 5), listOf(2, 6), listOf(2, 7), listOf(2, 8), listOf(2, 9), listOf(3, 4),
        listOf(3, 5), listOf(3, 6), listOf(3, 7), listOf(3, 8), listOf(3, 9), listOf(4, 5), listOf(4, 6), listOf(4, 7),
        listOf(4, 8), listOf(4, 9), listOf(5, 6), listOf(5, 7), listOf(5, 8), listOf(5, 9), listOf(6, 7), listOf(6, 8),
        listOf(6, 9), listOf(7, 8), listOf(7, 9), listOf(8, 9)
    )

    @Test
    fun `Should result in a winner for all the winning combinations`() {
        // start a tictacto game for each winning combination
        winningCombinations.forEach { combination ->
            // play the positions for this combination
            val tictacto = Tictacto()
            combination.forEach { position ->
                tictacto.play(position, testPlayer)
            }
            // assert that this combination results in a winner
            assertThat(tictacto.isWinner(testPlayer)).isTrue()
        }
    }

    @Test
    fun `Should not result in a winner for all the non-winning combinations`() {
        // start a tictacto game for each non-winning combination
        nonWinningCombinations.forEach { combination ->
            // play the positions for this combination
            val tictacto = Tictacto()
            combination.forEach { position ->
                tictacto.play(position, testPlayer)
            }
            // assert that this combination does not result in a winner
            assertThat(tictacto.isWinner(testPlayer)).isFalse()
        }
    }

}