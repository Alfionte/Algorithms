fun quickSort(list: List<Int>): List<Int> =
    when (list.size) {
        0, 1 -> list
        else -> {
            val pivot = list[0]
            val lowerNumbers = mutableListOf<Int>()
            val higherNumbers = mutableListOf<Int>()
            for (i in 1 until list.size) {
                if (pivot > list[i]) {
                    lowerNumbers.add(list[i])
                } else {
                    higherNumbers.add(list[i])
                }
            }
            quickSort(lowerNumbers) + pivot + quickSort(higherNumbers)
        }
    }.also { println("quickSort iteration") }