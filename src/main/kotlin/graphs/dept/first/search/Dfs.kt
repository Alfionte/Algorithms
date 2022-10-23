package graphs.dept.first.search

data class Friend(val name: String)

val dfsGraph = hashMapOf(
    Friend("Gabriele") to listOf(Friend("Elena"), Friend("Davide"), Friend("Gozde")),
    Friend("Elena") to listOf(Friend("Gabriele"), Friend("Ksenia"), Friend("Roman"), Friend("Sasha")),
    Friend("Davide") to listOf(Friend("Elena"), Friend("Greta"), Friend("Uzo"), Friend("Micheal")),
    Friend("Gozde") to listOf(Friend("Paolo"), Friend("Chiara")),
    Friend("Greta") to listOf(Friend("Ciccio"), Friend("Savino")),
    Friend("Sasha") to listOf(Friend("Jose"), Friend("Laura")),
    Friend("Uzo") to listOf(Friend("Gianni"), Friend("Pippo")),
    Friend("GiannaPaolo") to listOf(Friend("Luca"), Friend("Boario")),
)

/**
 * The dfs returns true if a path between [startNode] and [finishNode] exists.
 */
fun <T> dfs(graph: HashMap<T, List<T>>, startNode: T, finishNode: T): Boolean {
    val checkedNodes = mutableSetOf<T>()
    return hasPathDFS(graph, startNode, finishNode, checkedNodes)
}

private fun <T> hasPathDFS(
    graph: HashMap<T, List<T>>,
    currentNode: T,
    finishNode: T,
    checkedNodes: MutableSet<T>
): Boolean {
    return when {
        checkedNodes.contains(currentNode) -> false
        currentNode == finishNode -> true
        else -> {
            checkedNodes.add(currentNode)
            graph[currentNode]?.any { child -> hasPathDFS(graph, child, finishNode, checkedNodes) } ?: false
        }
    }
}