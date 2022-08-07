package test.router

import java.util.*

class Router {
    companion object {
        const val WILDCARD_SIGN = "*"
        const val START_OF_PARAM = "{"
        const val END_OF_PARAM = "}"
        const val DELIMITER = "/"
        const val VARIABLE_SIGN = "$"
    }

    private val routeMap = HashMap<String, String>()

    fun withRoute(route: String, result: String): Router {
        routeMap[route] = result
        return this
    }

    fun route(route: String): String? {
        val tokens = route.split(DELIMITER)
        for (entry in routeMap.entries) {
            val savedTokens = entry.key.split(DELIMITER)
            var isMatched = true
            val params = HashMap<String, String>()
            for ((index, savedToken) in savedTokens.withIndex()) {
                // wildcard
                if (savedToken == WILDCARD_SIGN) {
                    continue
                }
                // param
                if (savedToken.startsWith(START_OF_PARAM) && savedToken.endsWith(END_OF_PARAM)) {
                    val paramName = savedToken.substring(1, savedToken.length - 1)
                    params[paramName] = tokens[index]
                    continue
                }
                // matched token
                if (savedToken == tokens[index]) {
                    continue
                }
                isMatched = false
                break
            }
            if (isMatched) {
                return if (params.isEmpty()) {
                    entry.value
                } else {
                    var result = entry.value
                    for (param in params.keys) {
                        result = result.replace("$VARIABLE_SIGN$param", params[param]!!)
                    }
                    result
                }
            }
        }
        return null
    }
}
