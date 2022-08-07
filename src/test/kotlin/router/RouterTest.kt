package test.router

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class RouterTest {

    @Test
    fun `Given simple route When route Then return the matched result`() {
        // arrange
        val router = Router()
        router.withRoute("/bar", "bar result")

        // act
        val result = router.route("/bar")

        //
        result shouldBe "bar result"
    }

    @Test
    fun `Given simple route When route with not matched path Then return null`() {
        // arrange
        val router = Router()
        router.withRoute("/bar", "bar result")

        // act
        val result = router.route("/foo")

        //
        result shouldBe null
    }

    @Test
    fun `Given wildcard route When route Then return the matched result`() {
        // arrange
        val router = Router()
        router.withRoute("/*/bar", "bar result")

        // act
        val result = router.route("/test/bar")

        //
        result shouldBe "bar result"
    }

    @Test
    fun `Given route with param When route Then return the matched result`() {
        // arrange
        val router = Router()
        router.withRoute("/foo/{id}", "foo")

        // act
        val result = router.route("/foo/123")

        //
        result shouldBe "foo"
    }

    @Test
    fun `Given route with param When route Then return the matched result with param`() {
        // arrange
        val router = Router()
        router.withRoute("/foo/{id}", "foo: \$id")

        // act
        val result = router.route("/foo/123")

        //
        result shouldBe "foo: 123"
    }

    @Test
    fun `Given route with 2 params When route Then return the matched result with param`() {
        // arrange
        val router = Router()
        router.withRoute("/foo/{id}/{key}", "foo: id is \$id, key is \$key")

        // act
        val result = router.route("/foo/123/password")

        //
        result shouldBe "foo: id is 123, key is password"
    }
}