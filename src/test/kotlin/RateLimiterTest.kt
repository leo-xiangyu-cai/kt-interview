package test

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import test.RateLimiter

internal class RateLimiterTest {

    @Test
    fun `Given a request with an available bucket When call rateLimit Then return true`() {
        // arrange
        val rateLimiter = RateLimiter()
        val userId = 1

        // act
        val result = rateLimiter.rateLimit(userId, 0)

        // assert
        result shouldBe true
    }

    @Test
    fun `Given a single user request multiple times When call rateLimit reach limit Then return false`() {
        // arrange
        val rateLimiter = RateLimiter()
        val userId = 1
        repeat(4) {
            rateLimiter.rateLimit(userId, it)
        }

        // act
        val result = rateLimiter.rateLimit(userId, 4)

        // assert
        result shouldBe false
    }

    @Test
    fun `Given multiple users request multiple times When call rateLimit not reach limit Then return true`() {
        // arrange
        val rateLimiter = RateLimiter()
        val userId = 1
        repeat(4) {
            rateLimiter.rateLimit(it, it)
        }

        // act
        val result = rateLimiter.rateLimit(userId, 4)

        // assert
        result shouldBe true
    }

    @Test
    fun `Given a user request multiple times but some are expired When call rateLimit not reach limit Then return true`() {
        // arrange
        val rateLimiter = RateLimiter()
        val userId = 1
        repeat(4) {
            rateLimiter.rateLimit(userId, it * 3)
        }

        // act
        val result = rateLimiter.rateLimit(userId, 11)

        // assert
        result shouldBe true
    }

}