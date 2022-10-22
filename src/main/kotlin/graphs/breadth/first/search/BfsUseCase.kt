package graphs.breadth.first.search

import graphs.Node

object BfsUseCase {

    fun run() {
        println("--- BfsUseCase ---")

        val seller = bfs(Node(Person("Gabriele")), graph)
        println(seller)
        println()
    }
}