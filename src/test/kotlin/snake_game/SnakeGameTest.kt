package test.snake_game

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


internal class SnakeGameTest {

    @Test
    fun `Given an I-UP snake When move UP Then snake moves to the correct position`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        snakeGame.moveSnake(Direction.UP)

        // assert
        snakeGame.snake.direction shouldBe Direction.UP
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, 3), Node(0, 2), Node(0, 1))
    }

    @Test
    fun `Given an I-DOWN snake When move DOWN Then snake moves to the correct position`() {
        // arrange
        val iDownSnake = Snake(Direction.DOWN, arrayListOf(Node(0, 0), Node(0, 1), Node(0, 2)))
        val snakeGame = SnakeGame(iDownSnake)

        // act
        snakeGame.moveSnake(Direction.DOWN)

        // assert
        snakeGame.snake.direction shouldBe Direction.DOWN
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, -1), Node(0, 0), Node(0, 1))
    }

    @Test
    fun `Given an I-LEFT snake When move LEFT Then snake moves to the correct position`() {
        // arrange
        val iLeftSnake = Snake(Direction.LEFT, arrayListOf(Node(0, 0), Node(1, 0), Node(2, 0)))
        val snakeGame = SnakeGame(iLeftSnake)

        // act
        snakeGame.moveSnake(Direction.LEFT)

        // assert
        snakeGame.snake.direction shouldBe Direction.LEFT
        snakeGame.snake.nodes shouldBe arrayListOf(Node(-1, 0), Node(0, 0), Node(1, 0))
    }

    @Test
    fun `Given an I-RIGHT snake When move RIGHT Then snake moves to the correct position`() {
        // arrange
        val iRightSnake = Snake(Direction.RIGHT, arrayListOf(Node(2, 0), Node(1, 0), Node(0, 0)))
        val snakeGame = SnakeGame(iRightSnake)

        // act
        snakeGame.moveSnake(Direction.RIGHT)

        // assert
        snakeGame.snake.direction shouldBe Direction.RIGHT
        snakeGame.snake.nodes shouldBe arrayListOf(Node(3, 0), Node(2, 0), Node(1, 0))
    }

    @Test
    fun `Given an I-UP snake When move DOWN Then snake moves to the correct position`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        snakeGame.moveSnake(Direction.DOWN)

        // assert
        snakeGame.snake.direction shouldBe Direction.UP
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0))
    }

    @Test
    fun `Given an I-DOWN snake When move UP Then snake moves to the correct position`() {
        // arrange
        val iDownSnake = Snake(Direction.DOWN, arrayListOf(Node(0, 0), Node(0, 1), Node(0, 2)))
        val snakeGame = SnakeGame(iDownSnake)

        // act
        snakeGame.moveSnake(Direction.UP)

        // assert
        snakeGame.snake.direction shouldBe Direction.DOWN
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, 0), Node(0, 1), Node(0, 2))
    }

    @Test
    fun `Given an I-LEFT snake When move RIGHT Then snake moves to the correct position`() {
        // arrange
        val iLeftSnake = Snake(Direction.LEFT, arrayListOf(Node(0, 0), Node(1, 0), Node(2, 0)))
        val snakeGame = SnakeGame(iLeftSnake)

        // act
        snakeGame.moveSnake(Direction.RIGHT)

        // assert
        snakeGame.snake.direction shouldBe Direction.LEFT
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, 0), Node(1, 0), Node(2, 0))
    }

    @Test
    fun `Given an I-RIGHT snake When move LEFT Then snake moves to the correct position`() {
        // arrange
        val iRightSnake = Snake(Direction.RIGHT, arrayListOf(Node(2, 0), Node(1, 0), Node(0, 0)))
        val snakeGame = SnakeGame(iRightSnake)

        // act
        snakeGame.moveSnake(Direction.LEFT)

        // assert
        snakeGame.snake.direction shouldBe Direction.RIGHT
        snakeGame.snake.nodes shouldBe arrayListOf(Node(2, 0), Node(1, 0), Node(0, 0))
    }

    @Test
    fun `Given an I-UP snake When move LEFT Then snake moves to the correct position`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        snakeGame.moveSnake(Direction.LEFT)

        // assert
        snakeGame.snake.direction shouldBe Direction.LEFT
        snakeGame.snake.nodes shouldBe arrayListOf(Node(-1, 2), Node(0, 2), Node(0, 1))
    }

    @Test
    fun `Given an I-UP snake When move 5 steps Then snake should get one more node`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        for (i in 1..5) {
            snakeGame.moveSnake(Direction.UP)
        }

        // assert
        snakeGame.snake.direction shouldBe Direction.UP
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, 7), Node(0, 6), Node(0, 5), Node(0, 4))
    }

    @Test
    fun `Given an I-UP snake When move 12 steps Then snake should get one more node`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        for (i in 1..12) {
            snakeGame.moveSnake(Direction.UP)
        }

        // assert
        snakeGame.snake.direction shouldBe Direction.UP
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, 14), Node(0, 13), Node(0, 12), Node(0, 11), Node(0, 10))
    }

    @Test
    fun `Given an I-UP snake When move multiple steps Then snake should get one more node`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        snakeGame.moveSnake(Direction.UP)               // 03 02 01
        snakeGame.moveSnake(Direction.LEFT)             // -13 03 02
        snakeGame.moveSnake(Direction.UP)               // -14 -13 03
        snakeGame.moveSnake(Direction.RIGHT)            // 04 -14 -13
        snakeGame.moveSnake(Direction.RIGHT)            // 14 04 -14 -13
        snakeGame.moveSnake(Direction.RIGHT)            // 24 14 04 -14
        snakeGame.moveSnake(Direction.DOWN)             // 23 24 14 04
        snakeGame.moveSnake(Direction.DOWN)             // 22 23 24 14
        snakeGame.moveSnake(Direction.LEFT)             // 12 22 23 24
        snakeGame.moveSnake(Direction.DOWN)             // 11 12 22 23 24
        snakeGame.moveSnake(Direction.DOWN)             // 10 11 12 22 23
        snakeGame.moveSnake(Direction.RIGHT)            // 20 10 11 12 22

        // assert
        snakeGame.snake.direction shouldBe Direction.RIGHT
        snakeGame.snake.nodes shouldBe arrayListOf(Node(2, 0), Node(1, 0), Node(1, 1), Node(1, 2), Node(2, 2))
    }
}