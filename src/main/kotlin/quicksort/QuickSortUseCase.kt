package quicksort

object QuickSortUseCase {

    fun run() {
        println("--- QuickSortUseCase ---")

        val unsortedList = listOf(0, 1, 2, 4, 5, 9, 12, 3, 56, 79, 88, 96, 111)
        val sortedList = quickSort(unsortedList)
        val sortedImprovedList = improvedQuickSort(unsortedList)
        println("Sorted list [quickSort] : $sortedList")
        println("Sorted list [improvedQuickSort] : $sortedImprovedList")
        println()
    }
}