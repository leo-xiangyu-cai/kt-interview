import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DemoTest {

    @Test
    fun `Given  (1, 3, 6, 4, 1, 2) When checking Then return 5`() {
        // arrange
        val array = intArrayOf(1, 3, 6, 4, 1, 2)
        val demo = Demo()

        // act
        val result = demo.solution(array)

        // assert
        result shouldBe 5
    }

    @Test
    fun `Given  (1, 2, 3) When checking Then return 4`() {
        // arrange
        val array = intArrayOf(1, 2, 3)
        val demo = Demo()

        // act
        val result = demo.solution(array)

        // assert
        result shouldBe 4
    }

    @Test
    fun `Given  (−1, −3) When checking Then return 1`() {
        // arrange
        val array = intArrayOf(-1, -3)
        val demo = Demo()

        // act
        val result = demo.solution(array)

        // assert
        result shouldBe 1
    }
}