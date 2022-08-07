package random

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MergeTwoSortedArrayTest {

    @Test
    fun `Given (1), (2) When merge Then return (1,2)`() {
        // arrange
        val array1 = intArrayOf(1)
        val array2 = intArrayOf(2)
        val mergeTwoSortedArray = MergeTwoSortedArray()

        // act
        val result = mergeTwoSortedArray.merge(array1 = array1, array2 = array2)

        // assert
        result shouldBe intArrayOf(1, 2)
    }

    @Test
    fun `Given (1,2,2), (2,3,5) When merge Then return (1,2,3,5)`() {
        // arrange
        val array1 = intArrayOf(1, 2, 2)
        val array2 = intArrayOf(2, 3, 5)
        val mergeTwoSortedArray = MergeTwoSortedArray()

        // act
        val result = mergeTwoSortedArray.merge(array1 = array1, array2 = array2)

        // assert
        result shouldBe intArrayOf(1, 2, 3, 5)
    }

    @Test
    fun `Given (), () When merge Then return ()`() {
        // arrange
        val array1 = intArrayOf()
        val array2 = intArrayOf()
        val mergeTwoSortedArray = MergeTwoSortedArray()

        // act
        val result = mergeTwoSortedArray.merge(array1 = array1, array2 = array2)

        // assert
        result shouldBe intArrayOf()
    }
}