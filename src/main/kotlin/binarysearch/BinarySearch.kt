package binarysearch

/**
 * Return true if the searchedItem is found in the list
 * Return also the count of the iterations
 */
fun binarySearch(orderedList: List<Int>, searchedItem: Int): Pair<Boolean, Int> {

    var min = 0
    var max = orderedList.size - 1
    var count = 0

    while (min <= max) {
        count++
        val mid = (min + max) / 2
        val midGuess = orderedList[mid]

        when {
            searchedItem < midGuess -> {
                max = mid - 1
                min++
            }

            searchedItem > midGuess -> {
                min = mid + 1
                max--
            }

            else -> return true to count
        }
    }
    return false to count
}