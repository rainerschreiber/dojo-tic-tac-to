package org.dojo.tictacto.domain

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class TictactoGetAllPlayedPositionsTest {

    private val testPlayer = Player("Test player", "X")
    private val theOtherPlayer = Player("The other player", "O")

    @Test
    fun `Should return empty list if no position has been played yet`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        assertThat(tictacto.getAllPlayedPositions()).isEmpty()
    }

    @Test
    fun `Should return all played positions`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(5, testPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(5)
        tictacto.play(1, theOtherPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(1, 5)
        tictacto.play(4, testPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(1, 4, 5)
        tictacto.play(6, theOtherPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(1, 4, 5, 6)
        tictacto.play(7, testPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(1, 4, 5, 6, 7)
        tictacto.play(3, theOtherPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(1, 3, 4, 5, 6, 7)
        tictacto.play(9, testPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(1, 3, 4, 5, 6, 7, 9)
        tictacto.play(8, theOtherPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(1, 3, 4, 5, 6, 7, 8, 9)
        tictacto.play(2, testPlayer)
        assertThat(tictacto.getAllPlayedPositions()).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

}