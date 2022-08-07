package test

class RouteManager(private val routeList: HashMap<String, String>) {
    fun navigate(url: String): Route {
        if (routeList.containsKey(url)) {
            return Route(routeList[url]!!, hashMapOf())
        } else {
            for (route in routeList) {
                val urlTokens = url.split('/')
                val routeTokens = route.key.split('/')
                if (urlTokens.size != routeTokens.size) {
                    continue
                }
                val params = hashMapOf<String, String>()
                var isMatched = true
                for ((index, routeToken) in routeTokens.withIndex()) {
                    if (routeToken.startsWith("<") && routeToken.endsWith(">")) {
                        params[routeToken.substring(1, routeToken.length - 1)] = urlTokens[index]
                    } else {
                        if (urlTokens[index] != routeToken) {
                            isMatched = false
                            break
                        }
                    }
                }
                if (isMatched) {
                    return Route(route.value, params)
                } else {
                    continue
                }
            }
            return Route(ROUTE_404, hashMapOf())
        }
    }

    private fun getRoute404(): Route {
        return Route(ROUTE_404, hashMapOf())
    }

    companion object {
        const val ROUTE_404 = "404"
    }
}
