package usecase

import custom.data.structures.FastMutableListImpl
import custom.data.structures.FastOperationMax
import custom.data.structures.FastOperationMin

object AddableMaxMinListUseCase : UseCase {

    override fun run() {
        println("--- AddableMaxMinListUseCase ---")

        val min = FastOperationMin(Int.MAX_VALUE)
        val max = FastOperationMax(Int.MIN_VALUE)

        val list = FastMutableListImpl(min, max)
        list.addAll(listOf(1, 4, 76, 98, 5, 7, 2))

        println("Create list with 1, 4, 76, 98, 5, 7, 2")
        println("List : $list")
        println("List max : ${max.maxValue}")
        println("List min : ${min.minValue}")
        println()

        list.remove(98)
        list.remove(1)
        println("Remove 98, 1")
        println("List : $list")
        println("List max : ${max.maxValue}")
        println("List min : ${min.minValue}")
        println()

        list.add(100)
        list.add(0)
        println("Add 0, 100")
        println("List : $list")
        println("List max : ${max.maxValue}")
        println("List min : ${min.minValue}")
        println()

        list.removeAll(listOf(4, 5))
        println("Remove 4, 5")
        println("List : $list")
        println("List max : ${max.maxValue}")
        println("List min : ${min.minValue}")
        println()

        list.clear()
        println("List cleared: $list")
        println("List max : ${max.maxValue}")
        println("List min : ${min.minValue}")

        println()
    }
}