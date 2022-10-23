package usecase

import quicksort.improvedQuickSort

object QuickSortUseCase : UseCase {

    override fun run() {
        println("--- QuickSortUseCase ---")

        val unsortedList = listOf(0, 1, 2, 4, 5, 9, 12, 3, 56, 79, 88, 96, 111)
        val sortedList = quicksort.quickSort(unsortedList)
        val sortedImprovedList = improvedQuickSort(unsortedList)
        println("Sorted list [quickSort] : $sortedList")
        println("Sorted list [improvedQuickSort] : $sortedImprovedList")
        println()
    }
}