package test

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import test.VoteManager

internal class VoteManagerTest {

    @Test
    fun `Given an empty vote list -  When getRank - Then return empty string`() {
        // arrange
        val votes = emptyList<String>()
        val voteManager = VoteManager()

        // act
        val result = voteManager.getRank(votes)

        // assert
        result shouldBe ""
    }

    @Test
    fun `Given a vote list with one item -  When getRank - Then return the item`() {
        // arrange
        val votes = listOf("ABC")
        val voteManager = VoteManager()

        // act
        val result = voteManager.getRank(votes)

        // assert
        result shouldBe "ABC"
    }

    @Test
    fun `Given a vote list with lowercase -  When getRank - Then return the matched result`() {
        // arrange
        val votes = listOf("aBC")
        val voteManager = VoteManager()

        // act
        val result = voteManager.getRank(votes)

        // assert
        result shouldBe "ABC"
    }

    @Test
    fun `Given a vote list -  When getRank - Then return the matched result`() {
        // arrange
        val votes = listOf("ACB", "ABC", "BCA")
        val voteManager = VoteManager()

        // act
        val result = voteManager.getRank(votes)

        // assert
        result shouldBe "ABC"
    }

    @Test
    fun `Given a vote list with tie -  When getRank - Then return the matched result`() {
        // arrange
        val votes = listOf("ACB", "ABC", "BCA", "BCA")
        val voteManager = VoteManager()

        // act
        val result = voteManager.getRank(votes)

        // assert
        result shouldBe "BAC"
    }

    @Test
    fun `Given a vote list with tie and more than 3 candidates -  When getRank - Then return the matched result`() {
        // arrange
        val votes = listOf("ACBDEF", "ABCEDF", "BCAEDF", "BCADFE")
        val voteManager = VoteManager()

        // act
        val result = voteManager.getRank(votes)

        // assert
        result shouldBe "BACDEF"
    }
}