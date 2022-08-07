package random

class MergeTwoSortedArray {
    fun merge(array1: IntArray, array2: IntArray): IntArray {
        var cursor1 = 0
        var cursor2 = 0
        val arrayList = arrayListOf<Int>()
        while (cursor1 < array1.size || cursor2 < array2.size) {
            if (cursor1 > array1.size - 1) {
                addValue(arrayList, array2[cursor2])
                cursor2++
                continue
            }
            if (cursor2 > array2.size - 1) {
                addValue(arrayList, array1[cursor1])
                cursor1++
                continue
            }
            if (array1[cursor1] < array2[cursor2]) {
                addValue(arrayList, array1[cursor1])
                cursor1++
            } else {
                addValue(arrayList, array2[cursor2])
                cursor2++
            }
        }
        return arrayList.toIntArray()
    }

    private fun addValue(arrayList: ArrayList<Int>, value: Int) {
        if (arrayList.isEmpty()) {
            arrayList.add(value)
        }
        if (arrayList.last() == value) {
            return
        } else {
            arrayList.add(value)
        }
    }
}