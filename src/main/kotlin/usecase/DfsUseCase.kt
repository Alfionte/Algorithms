package usecase

import graphs.dept.first.search.Friend
import graphs.dept.first.search.dfs
import graphs.dept.first.search.dfsGraph

object DfsUseCase : UseCase {

    override fun run() {
        println("--- DfsUseCase ---")

        val startNode = Friend("Gabriele")
        val finishNode = Friend("Ciccio")
        val hasPathFound = dfs(dfsGraph, startNode, finishNode)

        println("Do you have a path between startNode: ${startNode.name} and finishNode: ${finishNode.name}?")
        println("The answer is: $hasPathFound")

        println()
    }
}