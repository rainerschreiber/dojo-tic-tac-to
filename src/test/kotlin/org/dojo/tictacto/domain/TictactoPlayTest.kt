package org.dojo.tictacto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test
import kotlin.test.assertFailsWith

class TictactoPlayTest {

    private val testPlayer = Player("Test player", "X")
    private val theOtherPlayer = Player("The other player", "O")

    @Test
    fun `Should throw an exception when game is already finished because there is a winner`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(1, testPlayer)
        tictacto.play(9, theOtherPlayer)
        tictacto.play(2, testPlayer)
        tictacto.play(7, theOtherPlayer)
        val result = tictacto.play(3, testPlayer)
        assertThat(result?.winner).isEqualTo(testPlayer)
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Tictacto.play method when the game is already finished should throw an IllegalArgumentException",
            block = {
                tictacto.play(5, theOtherPlayer)
            }
        )
    }

    @Test
    fun `Should throw an exception when game is already finished because of a draw`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(5, testPlayer)
        tictacto.play(1, theOtherPlayer)
        tictacto.play(4, testPlayer)
        tictacto.play(6, theOtherPlayer)
        tictacto.play(7, testPlayer)
        tictacto.play(3, theOtherPlayer)
        tictacto.play(9, testPlayer)
        tictacto.play(8, theOtherPlayer)
        val result = tictacto.play(2, testPlayer)
        assertThat(result?.draw).isTrue()
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Tictacto.play method when the game is already finished should throw an IllegalArgumentException",
            block = {
                tictacto.play(5, theOtherPlayer)
            }
        )
    }

    @Test
    fun `Should throw an exception when it is not the player's turn to play`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Tictacto.play method when it is not the player's turn to play should throw an IllegalArgumentException",
            block = {
                tictacto.play(1, theOtherPlayer)
            }
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -2, -5, -20, -100, -1000, Integer.MIN_VALUE])
    fun `Should throw an exception when the game is played with a position value 0 or lower`(position: Int) {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Tictacto.play method with position value 0 or lower should throw an IllegalArgumentException",
            block = {
                tictacto.play(position, testPlayer)
            }
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 11, 12, 15, 20, 100, 1000, Integer.MAX_VALUE])
    fun `Should throw an exception when the game is played with a position value 10 or higher`(position: Int) {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Tictacto.play method with position value 10 or higher should throw an IllegalArgumentException",
            block = {
                tictacto.play(position, testPlayer)
            }
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [1,2,3,4,5,6,7,8,9])
    fun `Should throw an exception when a player tries to play a position that is already played`(position: Int) {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(position, testPlayer)
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Tictacto.play method with a position that is already played should throw an IllegalArgumentException",
            block = {
                tictacto.play(position, theOtherPlayer)
            }
        )
    }

    @Test
    fun `Should be able to play the game with position value 1`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(1, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf("X", " ", " ", " ", " ", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 2`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(2, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", "X", " ", " ", " ", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 3`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(3, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", "X", " ", " ", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 4`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(4, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", "X", " ", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 5`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(5, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", "X", " ", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 6`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(6, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", " ", "X", " ", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 7`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(7, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", " ", " ", "X", " ", " "))
    }

    @Test
    fun `Should be able to play the game with position value 8`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(8, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", " ", " ", " ", "X", " "))
    }

    @Test
    fun `Should be able to play the game with position value 9`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(9, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf(" ", " ", " ", " ", " ", " ", " ", " ", "X"))
    }

    @Test
    fun `Should switch from player after a player has played`() {
        val tictacto = Tictacto(testPlayer, theOtherPlayer)
        tictacto.play(1, testPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf("X", " ", " ", " ", " ", " ", " ", " ", " "))
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Tictacto.play method when it is not the player's turn to play should throw an IllegalArgumentException",
            block = {
                tictacto.play(2, testPlayer)
            }
        )
        tictacto.play(2, theOtherPlayer)
        assertThat(tictacto.board).isEqualTo(arrayOf("X", "O", " ", " ", " ", " ", " ", " ", " "))
        assertFailsWith<IllegalArgumentException>(
            message = "A call to Tictacto.play method when it is not the player's turn to play should throw an IllegalArgumentException",
            block = {
                tictacto.play(2, theOtherPlayer)
            }
        )
    }

}