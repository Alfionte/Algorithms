import graphs.Node
import graphs.dijkstra.Name
import graphs.dijkstra.dijkstraGraph
import graphs.dijkstra.dijkstraRun

fun main() {
    /*
    val unsortedList = listOf(0, 1, 2, 4, 5, 9, 12, 3, 56, 79, 88, 96, 111)
    val sortedImprovedList = improvedQuickSort(unsortedList)
    val binarySearch = binarySearch(sortedImprovedList, 111)
    val binarySearchImproved = binarySearchImproved(sortedImprovedList,  111)


    println("Sorted list: $sortedImprovedList")
    println("Binary search : $binarySearch")
    println("Binary search improved: $binarySearchImproved")
     */

    // val seller = bfs(Node(Person("Gabriele")), graph)
    // println(seller)

    dijkstraRun(dijkstraGraph, Node(Name("start")), Node(Name("finish")))
}