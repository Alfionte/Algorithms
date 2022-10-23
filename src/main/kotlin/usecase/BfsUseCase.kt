package usecase

import graphs.Node
import graphs.breadth.first.search.Person
import graphs.breadth.first.search.bfs
import graphs.breadth.first.search.graph

object BfsUseCase : UseCase {

    override fun run() {
        println("--- BfsUseCase ---")

        val seller = bfs(Node(Person("Gabriele")), graph)
        println(seller)
        println()
    }
}