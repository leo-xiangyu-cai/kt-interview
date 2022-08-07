class Demo {
    fun solution(array: IntArray): Int {
        array.sort()
        var missingValue = 1
        for (i in array) {
            if (i < 0) {
                continue
            }
            if (i == missingValue) {
                missingValue++
            }
            if (i > missingValue) {
                break
            }
        }
        return missingValue
    }
}