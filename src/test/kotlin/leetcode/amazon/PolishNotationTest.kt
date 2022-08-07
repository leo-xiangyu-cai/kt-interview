package leetcode.amazon

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class PolishNotationTest {

    @Test
    fun `Given plus notation Then return the correct result`() {
        // arrange
        val notation = "1,12,+"
        val polishNotation = PolishNotation()

        // act
        val result = polishNotation.calculate(notation)

        // assert
        result shouldBe 13
    }

    @Test
    fun `Given multiple notation Then return the correct result`() {
        // arrange
        val notation = "2,12,*"
        val polishNotation = PolishNotation()

        // act
        val result = polishNotation.calculate(notation)

        // assert
        result shouldBe 24
    }

    @Test
    fun `Given divide notation Then return the correct result`() {
        // arrange
        val notation = "22,2,/"
        val polishNotation = PolishNotation()

        // act
        val result = polishNotation.calculate(notation)

        // assert
        result shouldBe 11
    }

    @Test
    fun `Given minus notation Then return the correct result`() {
        // arrange
        val notation = "2,12,-"
        val polishNotation = PolishNotation()

        // act
        val result = polishNotation.calculate(notation)

        // assert
        result shouldBe -10
    }

    @Test
    fun `Given combined notation Then return correct result`() {
        // arrange
        val notation = "2,12,-,3,*"
        val polishNotation = PolishNotation()

        // act
        val result = polishNotation.calculate(notation)

        // assert
        result shouldBe -30
    }
}

