package org.dojo.tictacto.domain

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class TictactoCanPlayTest {

    private val testPlayer = Player("Test player", "X")

    @Test
    fun `Should return true when player can play any position`() {
        val tictacto = Tictacto()
        intArrayOf(1,2,3,4,5,6,7,8,9).forEach {
            assertThat(tictacto.canPlay(it)).isTrue()
        }
    }

    @Test
    fun `Should return false when player can not play any position`() {
        val tictacto = Tictacto()
        intArrayOf(1,2,3,4,5,6,7,8,9).forEach {
            tictacto.play(it, testPlayer)
        }
        intArrayOf(1,2,3,4,5,6,7,8,9).forEach {
            assertThat(tictacto.canPlay(it)).isFalse()
        }
    }

}