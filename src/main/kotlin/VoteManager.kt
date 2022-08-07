package test

class VoteManager {

    /**
     * @param votes - ["ABC", "ACB", "BCA"]
     * @return {string} - the ranked result "ABC"
     */
    fun getRank(votes: List<String>): String {
        if (votes.isEmpty()) {
            return ""
        }
        val candidates: HashMap<Char, RankResult> =
            votes[0].associate { Pair(it, RankResult(0, 0, 0)) } as HashMap<Char, RankResult>
        for (vote in votes) {
            candidates[vote[0]]?.let { it.first = it.first + 1 }
            candidates[vote[1]]?.let { it.second = it.second + 1 }
            candidates[vote[2]]?.let { it.third = it.third + 1 }
        }
        val result =
            candidates.entries.sortedWith(
                compareBy(
                    { it.value.first },
                    { it.value.second },
                    { it.value.third })
            ).asReversed().toList().map { it.key }.joinToString("")
        return result.uppercase()
    }
}

data class RankResult(
    var first: Int,
    var second: Int,
    var third: Int,
)