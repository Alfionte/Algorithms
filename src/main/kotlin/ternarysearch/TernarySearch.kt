package ternarysearch

fun ternarySearch(list: List<Int>, searched: Int, countParam: Int): Pair<Boolean, Int> {
    var count = countParam
    count++
    if (list.isEmpty()) return false to count

    val leftIndex: Int
    val rightIndex: Int
    when (list.size) {
        1 -> {
            leftIndex = 0
            rightIndex = 0
        }

        2 -> {
            leftIndex = 0
            rightIndex = 1
        }

        else -> {
            leftIndex = list.size / 3
            rightIndex = leftIndex * 2
        }
    }

    when (searched) {
        list[leftIndex], list[rightIndex] -> return true to count
        else -> {
            var newLeft = 0
            var newRight = 0
            if (searched < list[leftIndex]) {
                newLeft = 0; newRight = leftIndex
            }
            if (searched > list[leftIndex] && searched < list[rightIndex]) {
                newLeft = leftIndex; newRight = rightIndex
            }
            if (searched > list[rightIndex]) {
                newLeft = rightIndex; newRight = list.size - 1
            }
            return ternarySearch(list.subList(newLeft, newRight), searched, count)
        }
    }
}