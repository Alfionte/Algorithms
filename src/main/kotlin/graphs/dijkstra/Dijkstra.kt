package graphs.dijkstra

import graphs.Node

data class NodeDetails(
    val distance: Distance = Distance(Int.MAX_VALUE),
    val parent: Node<Name>? = null,
    val hasBeenVisited: Boolean = false
)

fun dijkstraRun(
    graph: HashMap<Node<Name>, HashMap<Node<Name>, Distance>>,
    startNode: Node<Name>,
    finishNode: Node<Name>
) {
    println("dijkstraRun started!")
    val nodesDetails = mutableMapOf<Node<Name>, NodeDetails>()

    // For every node, let's create a default node detail
    graph.keys.forEach { nodesDetails[it] = NodeDetails() }
    nodesDetails[startNode] = NodeDetails(distance = Distance(0))

    var currentNode: Node<Name>?
    do {
        val isFinishNodeNotVisited = nodesDetails[finishNode]?.hasBeenVisited == false
        currentNode = getLowestUnvisitedNode(nodesDetails)?.first

        if (currentNode != null && isFinishNodeNotVisited) {
            println("dijkstraRun current node: $currentNode")

            graph[currentNode].let { neighbours ->
                neighbours?.forEach { neighbour ->
                    val (node, nodeDistance) = neighbour
                    val neighbourDetail = nodesDetails[node]!!
                    val currentNodeDistance = nodesDetails[currentNode]!!.distance.distance

                    val newDistance = currentNodeDistance + nodeDistance.distance
                    if (neighbourDetail.distance.distance > newDistance) {
                        val updatedDetails: NodeDetails? = nodesDetails[node]?.copy(
                            distance = Distance(newDistance),
                            parent = currentNode
                        )
                        updatedDetails?.let { nodesDetails[node] = it }
                    }
                }
            }

            val updatedDetails: NodeDetails? = nodesDetails[currentNode]?.copy(hasBeenVisited = true)
            updatedDetails?.let { nodesDetails[currentNode!!] = it }

        } else {
            val finishDetails = nodesDetails[Node(Name("finish"))]
            println("---")
            println("Shortest distance: ${finishDetails?.distance?.distance}")

            print("Parents:")
            var parent = finishDetails?.parent
            while (parent != null) {
                print("${parent.item.nodeName} ")
                parent = nodesDetails[parent]?.parent
            }
            currentNode = null
        }
    } while (currentNode != null)

}

private fun getLowestUnvisitedNode(nodesDetails: MutableMap<Node<Name>, NodeDetails>): Pair<Node<Name>, NodeDetails>? =
    nodesDetails
        .filter { it.value.hasBeenVisited.not() }
        .toList()
        .minByOrNull { it.second.distance.distance }