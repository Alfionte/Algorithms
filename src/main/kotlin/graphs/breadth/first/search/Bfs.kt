package graphs.breadth.first.search

import graphs.Node

interface IsFound {
    val isItemCorrect: Boolean
}

data class Person(val name: String, override val isItemCorrect: Boolean = false) : IsFound

val graph = HashMap<Node<IsFound>, List<Node<IsFound>>>().apply {
    put(
        Node(Person("Gabriele")),
        listOf(Node(Person("Elena")), Node(Person("Davide")), Node(Person("Gozde")))
    )
    put(
        Node(Person("Elena")),
        listOf(Node(Person("Gabriele")), Node(Person("Ksenia")), Node(Person("Roman")), Node(Person("Sasha")))
    )
    put(
        Node(Person("Davide")),
        listOf(Node(Person("Elena")), Node(Person("Greta")), Node(Person("Uzo")), Node(Person("Micheal")))
    )
    put(Node(Person("Gozde")), listOf(Node(Person("Paolo")), Node(Person("Chiara"))))
    put(Node(Person("Greta")), listOf(Node(Person("Ciccio", true)), Node(Person("Savino"))))
    put(Node(Person("Sasha")), listOf(Node(Person("Jose")), Node(Person("Laura"))))
    put(Node(Person("Uzo")), listOf(Node(Person("Gianni")), Node(Person("Pippo"))))
}

fun <T : Node<IsFound>> bfs(startNode: T, graph: HashMap<T, List<T>>): T? {
    val queue = ArrayDeque<T>()
    val checkedPeople = hashSetOf(startNode)
    graph[startNode]?.let { queue.addAll(it) }

    while (!queue.isEmpty()) {
        val person = queue.removeFirst()
        checkedPeople.add(person)
        if (person.item.isItemCorrect) return person
        graph[person]?.let {
            val checkedFriends = it.toMutableList().apply { removeAll(checkedPeople) }
            queue.addAll(checkedFriends)
        }
    }
    return null
}