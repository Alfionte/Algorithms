package usecase

object MiddleNodeUseCase : UseCase {
    override fun run() {
        println("--- MiddleNodeUseCase ---")

        val result = middleNode(
            LinkedList(value = 1).apply {
                next = LinkedList(value = 2).apply {
                    next = LinkedList(value = 3).apply {
                        next = LinkedList(4)
                    }
                }
            }
        )

        println("Expected 3")
        println("found: ${result.value}")
        println()
    }
}

// This is an input class. Do not edit.
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun middleNode(linkedList: LinkedList): LinkedList {
    val list = mutableListOf<LinkedList>()
    var current: LinkedList? = linkedList

    do {
        current?.let { list.add(it) }
        current = current?.next
    } while (current != null)

    return list[list.size / 2]
}
