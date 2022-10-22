package graphs.dijkstra

import graphs.Node

object DijkstraUseCase {
    fun run() {
        println("--- DijkstraUseCase ---")
        dijkstraRun(dijkstraGraph, Node(Name("start")), Node(Name("finish")))
        println()
        println()
    }
}