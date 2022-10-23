package usecase

import graphs.Node
import graphs.dijkstra.Name
import graphs.dijkstra.dijkstraGraph
import graphs.dijkstra.dijkstraRun

object DijkstraUseCase : UseCase{
    override fun run() {
        println("--- DijkstraUseCase ---")
        dijkstraRun(dijkstraGraph, Node(Name("start")), Node(Name("finish")))
        println()
        println()
    }
}