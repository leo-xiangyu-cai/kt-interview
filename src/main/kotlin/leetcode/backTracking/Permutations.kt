package leetcode.backTracking

//LeetCode 46
class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        if (nums.size == 1) {
            return listOf(nums.toList())
        } else {
            for (i in nums.indices) {
                val num = nums[i]
                val listWithoutNum = nums.toMutableList()
                listWithoutNum.removeAt(i)
                val resultsWithoutNum = permute(listWithoutNum.toIntArray())
                for (tempResult in resultsWithoutNum) {
                    val tempResultMutableList = tempResult.toMutableList()
                    tempResultMutableList.add(0, num)
                    result.add(tempResultMutableList)
                }
            }
        }
        return result
    }
//    fun permute(nums: IntArray): List<List<Int>> {
//        if (nums.size == 1) {
//            return listOf(nums.toList())
//        }
//        val result = arrayListOf<List<Int>>()
//        for (i in nums.indices) {
//            val num = nums[i]
//            val listWithoutNum = nums.toMutableList()
//            listWithoutNum.removeAt(i)
//            val resultsWithoutNum = permute(listWithoutNum.toIntArray())
//            for (resultWithoutNum in resultsWithoutNum) {
//                val tempList = arrayListOf<Int>()
//                tempList.add(num)
//                tempList.addAll(resultWithoutNum)
//                result.add(tempList)
//            }
//        }
//        return result
//    }
}