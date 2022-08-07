package code1

interface SnakeGameInterface {
    fun moveSnake(snakeDirection: Direction)
    fun isGameOver(): Boolean
}

class SnakeGame(val snake: Snake) : SnakeGameInterface {
    companion object {
        const val STEP_FOR_GROWTH = 5
    }

    override fun moveSnake(snakeDirection: Direction) {
        val tail = snake.nodes.last().copy()
        val head = snake.nodes.first()
        for (i in snake.nodes.size - 1 downTo 1) {
            val current = snake.nodes[i]
            val pre = snake.nodes[i - 1]
            current.x = pre.x
            current.y = pre.y
        }
        when (snakeDirection) {
            Direction.UP -> {
                head.y++
            }
            Direction.DOWN -> {
                head.y--
            }
            Direction.LEFT -> {
                head.x--
            }
            Direction.RIGHT -> {
                head.x++
            }
        }
        snake.direction = snakeDirection
        snake.moves++
        if (snake.moves % STEP_FOR_GROWTH == 0) {
            snake.nodes.add(tail)
        }
    }

    override fun isGameOver(): Boolean {
        val head = snake.nodes.first()
        for (i in 1 until snake.nodes.size) {
            val current = snake.nodes[i]
            if (head.x == current.x && head.y == current.y) {
                return true
            }
        }
        return false
    }
}

data class Snake(var direction: Direction, val nodes: ArrayList<Node>, var moves: Int = 0)

data class Node(var x: Int, var y: Int)

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}