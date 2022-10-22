import binarysearch.BinarySearchUseCase
import custom.data.structures.AddableMaxMinListUseCase
import graphs.breadth.first.search.BfsUseCase
import graphs.dijkstra.DijkstraUseCase
import quicksort.QuickSortUseCase

fun main() {
    BinarySearchUseCase.run()
    QuickSortUseCase.run()
    BfsUseCase.run()
    DijkstraUseCase.run()
    AddableMaxMinListUseCase.run()
}