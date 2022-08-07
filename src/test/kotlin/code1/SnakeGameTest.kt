package code1

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SnakeGameTest {

    @Test
    fun `Given an I-UP snake When move UP Then move to the correct position`() {
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
    fun `Given an I-DOWN snake When move DOWN Then move to the correct position`() {
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
    fun `Given an I-LEFT snake When move LEFT Then move to the correct position`() {
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
    fun `Given an I-RIGHT snake When move RIGHT Then move to the correct position`() {
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
    fun `Given an I-UP snake When move 5 steps Then get one more node`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        for (i in 0..4) {
            snakeGame.moveSnake(Direction.UP)
        }

        // assert
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, 7), Node(0, 6), Node(0, 5), Node(0, 4))

    }

    @Test
    fun `Given an I-UP snake When move 12 steps Then get one more node`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        for (i in 0..11) {
            snakeGame.moveSnake(Direction.UP)
        }

        // assert
        snakeGame.snake.nodes shouldBe arrayListOf(Node(0, 14), Node(0, 13), Node(0, 12), Node(0, 11), Node(0, 10))
    }

    @Test
    fun `Given an I-UP snake When move LEFT Then move to the correct position`() {
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
    fun `Given an I-UP snake When move multiple steps Then game over`() {
        // arrange
        val iUpSnake = Snake(Direction.UP, arrayListOf(Node(0, 2), Node(0, 1), Node(0, 0), Node(0, -1), Node(0, -2)))
        val snakeGame = SnakeGame(iUpSnake)

        // act
        snakeGame.moveSnake(Direction.LEFT)
        snakeGame.moveSnake(Direction.DOWN)
        snakeGame.moveSnake(Direction.RIGHT)

        // assert
        snakeGame.isGameOver() shouldBe true
    }
}