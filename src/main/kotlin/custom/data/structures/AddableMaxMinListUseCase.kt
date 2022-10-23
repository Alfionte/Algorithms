package custom.data.structures

object AddableMaxMinListUseCase {

    fun run() {
        println("--- AddableMaxMinListUseCase ---")

        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        val onChange = { lastAdded: Int ->
            println("Added number - $lastAdded")
            if (max < lastAdded) max = lastAdded
            if (min > lastAdded) min = lastAdded
        }

        val onClear = {
            println("onClear")
            max = Int.MIN_VALUE
            min = Int.MAX_VALUE
        }

        val listMax = AddableListImpl(onChange, onClear)
        listMax.addAll(listOf(1, 4, 76, 98, 5, 7, 2))

        println("List : $listMax")
        println("List max : $max")
        println("List min : $min")
        println()

        listMax.add(100)
        listMax.add(0)
        println("List : $listMax")
        println("List max : $max")
        println("List min : $min")
        println()

        listMax.clear()
        println("List cleared: $listMax")
        println("List max : $max")
        println("List min : $min")

        println()
    }
}