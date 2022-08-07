package leetcode.backTracking

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class PermutationsTest {

    @Test
    fun `Given nums (1) Then returns (1)`() {
        // arrange
        val nums = intArrayOf(1)
        val permutations = Permutations()

        // act
        val result = permutations.permute(nums)

        // assert
        result shouldBe listOf(listOf(1))

    }

    @Test
    fun `Given nums (1,2) Then returns (1,2)(2,1)`() {
        // arrange
        val nums = intArrayOf(1, 2)
        val permutations = Permutations()

        // act
        val result = permutations.permute(nums)

        // assert
        val expected = listOf(
            listOf(1, 2),
            listOf(2, 1),
        )
        result shouldContainAll expected
        expected shouldContainAll result

    }

    @Test
    fun `Given nums (1,2,3) Then returns (1,2,3)(1,3,2)(2,1,3)(2,3,1)(3,1,2)(3,2,1)`() {
        // arrange
        val nums = intArrayOf(1, 2, 3)
        val permutations = Permutations()

        // act
        val result = permutations.permute(nums).sortedBy { x -> x[0] }

        // assert
        val expected = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1)
        )
        result shouldContainAll expected
        expected shouldContainAll result

    }
}