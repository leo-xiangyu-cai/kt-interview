package leetcode

class MultiplyStrings {
    // time complexity O(mn+m+n)
    fun multiply(num1: String, num2: String): String {
        val resultArray = IntArray(num1.length + num2.length) { 0 }
        for (i in num1.length - 1 downTo 0) {
            for (j in num2.length - 1 downTo 0) {
                val tempResult = num1[i].toString().toInt() * num2[j].toString().toInt()
                val ones = tempResult % 10
                val tens = tempResult / 10
                val onesPosition = (num1.length - 1) - i + (num2.length - 1) - j
                val tensPosition = onesPosition + 1
                resultArray[onesPosition] += ones
                resultArray[tensPosition] += tens
            }
        }
        for (i in 0 until resultArray.size - 1) {
            if (resultArray[i] >= 10) {
                resultArray[i + 1] += resultArray[i] / 10
                resultArray[i] = resultArray[i] % 10
            }
        }
        var isStarted = false
        var resultString = ""
        for (i in resultArray.size - 1 downTo 0) {
            if (isStarted || resultArray[i] > 0) {
                resultString += resultArray[i]
                isStarted = true
            }
        }
        if (!isStarted) return "0"
        return resultString
    }
}