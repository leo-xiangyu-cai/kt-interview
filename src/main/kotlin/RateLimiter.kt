package test

class RateLimiter {
    companion object {
        const val BUCKET_TIME = 10
        const val MAX_REQUEST_CREDIT = 10
    }

    var currentCredit = 0
    private val userRequestsMap = HashMap<Int, ArrayList<Request>>()

    fun rateLimit(customerId: Int, time: Int): Boolean {
        if (userRequestsMap.containsKey(customerId)) {
            val tempCredit = userRequestsMap[customerId]!!.filter { time - it.requestTime <= BUCKET_TIME }.count()
            return if (currentCredit + tempCredit > MAX_REQUEST_CREDIT) {
                false
            } else {
                currentCredit += tempCredit
                userRequestsMap[customerId]!!.add(Request(time))
                true
            }
        } else {
            return if (currentCredit + 1 > MAX_REQUEST_CREDIT) {
                false
            } else {
                userRequestsMap[customerId] = arrayListOf(Request(time))
                currentCredit++
                true
            }
        }
    }

    data class Request(val requestTime: Int)
}