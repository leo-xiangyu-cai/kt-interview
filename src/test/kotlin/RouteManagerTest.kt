package test

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeAll

internal class RouteManagerTest {
    companion object {
        lateinit var routeManager: RouteManager

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            routeManager = RouteManager(
                hashMapOf(
                    "/home" to "home",
                    "/profile/<id>" to "profile",
                    "/category/<lv1>/<lv2>" to "category"
                )
            )
        }
    }

    @Test
    fun `Given a valid url When navigate Then return a matched Route`() {
        // act
        val result = routeManager.navigate("/home")

        // assert
        result shouldBe Route("home", hashMapOf())
    }

    @Test
    fun `Given an invalid url When navigate Then return a 404 Route`() {
        // act
        val result = routeManager.navigate("/index")

        // assert
        result shouldBe Route(RouteManager.ROUTE_404, hashMapOf())
    }

    @Test
    fun `Given a valid url with one params When navigate Then return a matched Route`() {
        // act
        val result = routeManager.navigate("/profile/123")

        // assert
        result shouldBe Route("profile", hashMapOf("id" to "123"))
    }

    @Test
    fun `Given a valid url with two params When navigate Then return a matched Route`() {
        // act
        val result = routeManager.navigate("/category/123/321")

        // assert
        result shouldBe Route("category", hashMapOf("lv1" to "123", "lv2" to "321"))
    }
}