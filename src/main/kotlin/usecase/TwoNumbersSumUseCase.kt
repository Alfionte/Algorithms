package usecase

object TwoNumbersSumUseCase : UseCase {
    override fun run() {
        println("--- TwoNumbersSumUseCase ---")

        val solution = twoNumberSum(
            array = mutableListOf(3, 5, -4, 8, 11, 1, -1, 6),
            targetSum = 10
        )

        println("Expected [11, -1], found: $solution")
        println()
    }
}

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val map = mutableMapOf<Int, Int>()

    array.forEachIndexed { index, number ->
        if (map.contains(number)){
            val subtractionIndex = map[number]!!
            val subtracted = array[subtractionIndex]
            return listOf(subtracted, number)
        }else{
            val subtracted = targetSum - number
            map[subtracted] = index
        }
    }
    // no pair found
    return emptyList()
}
