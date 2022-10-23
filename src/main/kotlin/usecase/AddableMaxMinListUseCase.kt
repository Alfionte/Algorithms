package usecase

import custom.data.structures.AddableListImpl
import custom.data.structures.AddableOperationMax
import custom.data.structures.AddableOperationMin

object AddableMaxMinListUseCase : UseCase {

    override fun run() {
        println("--- AddableMaxMinListUseCase ---")

        val min = AddableOperationMin(Int.MAX_VALUE)
        val max = AddableOperationMax(Int.MIN_VALUE)

        val listMax = AddableListImpl(min, max)
        listMax.addAll(listOf(1, 4, 76, 98, 5, 7, 2))

        println("List : $listMax")
        println("List max : ${max.maxValue}")
        println("List min : ${min.minValue}")
        println()

        listMax.add(100)
        listMax.add(0)
        println("List : $listMax")
        println("List max : ${max.maxValue}")
        println("List min : ${min.minValue}")
        println()

        listMax.clear()
        println("List cleared: $listMax")
        println("List max : ${max.maxValue}")
        println("List min : ${min.minValue}")

        println()
    }
}