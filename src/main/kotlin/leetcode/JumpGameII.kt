package leetcode

import kotlin.math.max

class JumpGameII {
    fun jump(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }
        if (nums[0] >= nums.size - 1) {
            return 1
        }
        val jumpList = IntArray(nums.size) { 0 }
        jumpList[1] = nums[0]
        for (i in 2..nums.size) {
            var longest = 0
            for (j in jumpList[i - 2]..jumpList[i - 1]) {
                longest = max(nums[j] + j, longest)
                if (longest >= nums.size - 1) {
                    return i
                }
            }
            jumpList[i] = longest
        }
        return -1
    }
}