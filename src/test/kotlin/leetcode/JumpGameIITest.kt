package leetcode

import io.kotest.matchers.shouldBe
import leetcode.JumpGameII
import org.junit.jupiter.api.Test

internal class JumpGameIITest {

    @Test
    fun `Given (1) When jump Then return 0`() {
        // arrange
        val nums = intArrayOf(1)
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 0
    }

    @Test
    fun `Given (3, 1, 3) When jump Then return 1`() {
        // arrange
        val nums = intArrayOf(3, 1, 3)
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 1
    }

    @Test
    fun `Given (2,3,1,1,4) When jump Then return 2`() {
        // arrange
        val nums = intArrayOf(2, 3, 1, 1, 4)
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 2
    }

    @Test
    fun `Given (2,3,0,1,4) When jump Then return 2`() {
        // arrange
        val nums = intArrayOf(2, 3, 0, 1, 4)
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 2
    }

    @Test
    fun `Given (0) When jump Then return 0`() {
        // arrange
        val nums = intArrayOf(0)
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 0
    }

    @Test
    fun `Given (1,2) When jump Then return 1`() {
        // arrange
        val nums = intArrayOf(1, 2)
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 1
    }

    @Test
    fun `Given (1,2,3) When jump Then return 2`() {
        // arrange
        val nums = intArrayOf(1, 2, 3)
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 2
    }

    @Test
    fun `Given (5,9,3,2,1,0,2,3,3,1,0,0) When jump Then return 3`() {
        // arrange
        val nums = intArrayOf(5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0)
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 3
    }

    @Test
    fun `Given (5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5) When jump Then return 3`() {
        // arrange
        val nums = intArrayOf(
            5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5,
            2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5
        )
        val jumpGameII = JumpGameII()

        // act
        val result = jumpGameII.jump(nums)

        // assert
        result shouldBe 5
    }
}