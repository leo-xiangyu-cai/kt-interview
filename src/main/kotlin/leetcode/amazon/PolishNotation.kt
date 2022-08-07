package leetcode.amazon

import java.lang.Exception
import java.util.*

class PolishNotation {
    fun calculate(input: String): Int {
        val stack = Stack<Int>()
        for (token in input.split(',')) {
            if (token.isNumber()) {
                stack.push(token.toInt())
                continue
            }
            when (token) {
                "+" -> stack.push(stack.pop() + stack.pop())
                "-" -> {
                    val num1 = stack.pop()
                    val num2 = stack.pop()
                    stack.push(num2 - num1)
                }
                "*" -> stack.push(stack.pop() * stack.pop())
                "/" -> {
                    val num1 = stack.pop()
                    val num2 = stack.pop()
                    stack.push(num2 / num1)
                }
            }
        }
        return stack.pop()
    }

    private fun String.isNumber(): Boolean {
        return try {
            this.toInt()
            true
        } catch (e: Exception) {
            false
        }
    }
}