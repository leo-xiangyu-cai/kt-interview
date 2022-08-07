package code2

class FileManager {
    val files = ArrayList<File>()

    fun getTotalSize(): Long {
        var totalSize: Long = 0
        for (file in files) {
            totalSize += file.size
        }
        return totalSize
    }

    fun getTopCollections(n: Int): List<String> {

        val collectionsMap = HashMap<String, Long>()
        for (file in files) {
            if (!collectionsMap.containsKey(file.collection[0])) {
                collectionsMap[file.collection[0]] = file.size
            } else {
                collectionsMap[file.collection[0]] = collectionsMap[file.collection[0]]!! + file.size
            }
        }
        return collectionsMap.toList().sortedWith(compareByDescending { it.second }).map { it.first }
            .filter { it.isNotEmpty() }.subList(0, n)
    }
}

data class File(val name: String, val size: Long, val collection: List<String>)