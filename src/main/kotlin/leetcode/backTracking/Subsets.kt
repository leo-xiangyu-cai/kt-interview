package leetcode.backTracking

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<ArrayList<Int>>(arrayListOf())
        for (num in nums) {
            val resultsWithNum = arrayListOf<ArrayList<Int>>()
            for (item in result) {
                val newSetWithNum = ArrayList(item)
                newSetWithNum.add(num)
                resultsWithNum.add(newSetWithNum)
            }
            result.addAll(resultsWithNum)
        }
        return result
    }
}