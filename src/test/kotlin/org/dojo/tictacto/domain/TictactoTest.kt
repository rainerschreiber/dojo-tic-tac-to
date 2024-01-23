package org.dojo.tictacto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFailsWith

class TictactoTest {

    private val testPlayer = Player("Test player", "X")

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -2, -5, -20, -100, -1000, Integer.MIN_VALUE])
    fun `Should throw an exception when play the game with position values 0 or lower`(position: Int) {
        val tictacto = Tictacto()
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Game.play method with position value 0 or lower should throw an IllegalArgumentException",
            block = {
                tictacto.play(position, testPlayer)
            }
        )
    }

    @Test
    fun `Should be able to play the game with position value 1`() {
        val tictacto = Tictacto()
        tictacto.play(1, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf("X", " ", " ", " ", " ", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 2`() {
        val tictacto = Tictacto()
        tictacto.play(2, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", "X", " ", " ", " ", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 3`() {
        val tictacto = Tictacto()
        tictacto.play(3, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", "X", " ", " ", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 4`() {
        val tictacto = Tictacto()
        tictacto.play(4, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", "X", " ", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 5`() {
        val tictacto = Tictacto()
        tictacto.play(5, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", "X", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 6`() {
        val tictacto = Tictacto()
        tictacto.play(6, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", " ", "X", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 7`() {
        val tictacto = Tictacto()
        tictacto.play(7, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", " ", " ", "X", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 8`() {
        val tictacto = Tictacto()
        tictacto.play(8, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", " ", " ", " ", "X", " "))
    }

    @Test
    fun `Should be able to play the game with position value 9`() {
        val tictacto = Tictacto()
        tictacto.play(9, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", " ", " ", " ", " ", "X"))
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 11, 12, 15, 20, 100, 1000, Integer.MAX_VALUE])
    fun `Should throw an exception when play the game with position values 10 or higher`(position: Int) {
        val tictacto = Tictacto()
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Game.play method with position value 10 or higher should throw an IllegalArgumentException",
            block = {
                tictacto.play(position, testPlayer)
            }
        )
    }

}