package test.snake_game

class SnakeGame(val snake: Snake) {
    fun moveSnake(direction: Direction) {
        if (isOpposite(direction)) {
            return
        }
        snake.newGeneratedNode = snake.nodes.last().copy()
        for (i in (snake.nodes.size - 1) downTo 1) {
            val current = snake.nodes[i]
            val pre = snake.nodes[i - 1]
            current.x = pre.x
            current.y = pre.y
        }
        val head = snake.nodes.first()
        when (direction) {
            Direction.UP -> head.y++
            Direction.DOWN -> head.y--
            Direction.LEFT -> head.x--
            Direction.RIGHT -> head.x++
        }
        snake.direction = direction
        snake.moves++
        if (snake.moves % 5 == 0) {
            snake.newGeneratedNode?.let {
                snake.nodes.add(it)
            }
        }

    }

    private fun isOpposite(direction: Direction): Boolean {
        return snake.direction == Direction.UP && direction == Direction.DOWN
                || snake.direction == Direction.DOWN && direction == Direction.UP
                || snake.direction == Direction.LEFT && direction == Direction.RIGHT
                || snake.direction == Direction.RIGHT && direction == Direction.LEFT
    }
}

data class Snake(
    var direction: Direction,
    val nodes: ArrayList<Node>,
    var newGeneratedNode: Node? = null,
    var moves: Int = 0
)

data class Node(var x: Int, var y: Int)

enum class Direction { UP, DOWN, LEFT, RIGHT }