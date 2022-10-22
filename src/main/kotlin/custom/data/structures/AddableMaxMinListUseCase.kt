package custom.data.structures

object AddableMaxMinListUseCase {

    fun run() {
        val listMax = AddableMaxMixList(
            maxDefault = Int.MIN_VALUE,
            minDefault = Int.MAX_VALUE
        )
        listMax.addAll(listOf(1, 4, 76, 98, 5, 7, 2))

        println("List : $listMax")
        println("List max : ${listMax.maxElement}")
        println("List min : ${listMax.minElement}")

        listMax.add(100)
        listMax.add(0)

        println("List max : ${listMax.maxElement}")
        println("List min : ${listMax.minElement}")
    }
}