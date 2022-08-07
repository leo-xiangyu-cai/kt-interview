package leetcode

import io.kotest.matchers.shouldBe
import leetcode.MultiplyStrings
import org.junit.jupiter.api.Test

internal class MultiplyStringsTest {

    @Test
    fun `Given 0 and 0 When multiple Then return 0`() {
        // arrange
        val num1 = "0"
        val num2 = "0"
        val multiplyStrings = MultiplyStrings()

        // act
        val result = multiplyStrings.multiply(num1 = num1, num2 = num2)

        // assert
        result shouldBe "0"
    }

    @Test
    fun `Given 2 and 3 When multiple Then return 6`() {
        // arrange
        val num1 = "2"
        val num2 = "3"
        val multiplyStrings = MultiplyStrings()

        // act
        val result = multiplyStrings.multiply(num1 = num1, num2 = num2)

        // assert
        result shouldBe "6"
    }

    @Test
    fun `Given 2 and 5 When multiple Then return 10`() {
        // arrange
        val num1 = "2"
        val num2 = "5"
        val multiplyStrings = MultiplyStrings()

        // act
        val result = multiplyStrings.multiply(num1 = num1, num2 = num2)

        // assert
        result shouldBe "10"
    }

    @Test
    fun `Given 2 and 6 When multiple Then return 12`() {
        // arrange
        val num1 = "2"
        val num2 = "6"
        val multiplyStrings = MultiplyStrings()

        // act
        val result = multiplyStrings.multiply(num1 = num1, num2 = num2)

        // assert
        result shouldBe "12"
    }

    @Test
    fun `Given 5 and 16 When multiple Then return 80`() {
        // arrange
        val num1 = "5"
        val num2 = "16"
        val multiplyStrings = MultiplyStrings()

        // act
        val result = multiplyStrings.multiply(num1 = num1, num2 = num2)

        // assert
        result shouldBe "80"
    }

    @Test
    fun `Given 52 and 16 When multiple Then return 832`() {
        // arrange
        val num1 = "52"
        val num2 = "16"
        val multiplyStrings = MultiplyStrings()

        // act
        val result = multiplyStrings.multiply(num1 = num1, num2 = num2)

        // assert
        result shouldBe "832"
    }

    @Test
    fun `Given 1234567 and 7654321 When multiple Then return 832`() {
        // arrange
        val num1 = "1234567"
        val num2 = "7654321"
        val multiplyStrings = MultiplyStrings()

        // act
        val result = multiplyStrings.multiply(num1 = num1, num2 = num2)

        // assert
        result shouldBe "9449772114007"
    }
}