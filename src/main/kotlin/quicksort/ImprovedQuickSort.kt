package quicksort

fun improvedQuickSort(list: List<Int>): List<Int> =
    when (list.size) {
        0, 1 -> list
        else -> {
            val pivot = list.first()
            val lowerNumbers = mutableListOf<Int>()
            val higherNumbers = mutableListOf<Int>()
            var areLowerNumbersSorted = true
            var areHigherNumbersSorted = true

            for (i in 1 until list.size) {
                val currentElement = list[i]
                if (pivot > currentElement) {
                    if (lowerNumbers.isNotEmpty() && lowerNumbers.last() < currentElement) {
                        areLowerNumbersSorted = false
                    }
                    lowerNumbers.add(currentElement)
                } else {
                    if (higherNumbers.isNotEmpty() && higherNumbers.last() > currentElement) {
                        areHigherNumbersSorted = false
                    }
                    higherNumbers.add(currentElement)
                }
            }
            when {
                areLowerNumbersSorted && areHigherNumbersSorted -> lowerNumbers + pivot + higherNumbers
                areLowerNumbersSorted -> lowerNumbers + pivot + improvedQuickSort(higherNumbers)
                areHigherNumbersSorted -> improvedQuickSort(lowerNumbers) + pivot + higherNumbers
                else -> improvedQuickSort(lowerNumbers) + pivot + improvedQuickSort(higherNumbers)
            }
        }
    }.also { println("Improved quickSort iteration") }