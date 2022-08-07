package leetcode.backTracking

import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SubsetsTest {

    @Test
    fun `Given nums (1) Then returns matched result`() {
        // arrange
        val nums = intArrayOf(1)
        val subsets = Subsets()

        // act
        val result = subsets.subsets(nums)

        // assert
        result shouldBe listOf(listOf(), listOf(1))

    }

    @Test
    fun `Given nums (1,2) Then returns matched result`() {
        // arrange
        val nums = intArrayOf(1, 2)
        val subsets = Subsets()

        // act
        val result = subsets.subsets(nums)

        // assert
        val expected = listOf(
            listOf(),
            listOf(1),
            listOf(2),
            listOf(1, 2)
        )
        result shouldContainAll expected
        expected shouldContainAll result

    }

    @Test
    fun `Given nums (1,2,3) Then returns matched result`() {
        // arrange
        val nums = intArrayOf(1, 2, 3)
        val subsets = Subsets()

        // act
        val result = subsets.subsets(nums)

        // assert
        val expected = listOf(
            listOf(),
            listOf(1),
            listOf(2),
            listOf(3),
            listOf(1, 2),
            listOf(1, 3),
            listOf(2, 3),
            listOf(1, 2, 3),
        )
        result shouldContainAll expected
        expected shouldContainAll result

    }
}