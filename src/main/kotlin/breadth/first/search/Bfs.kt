package breadth.first.search

interface MangoSeller {
    val isMangoSeller: Boolean
}

data class PersonNode(val name: String, override val isMangoSeller: Boolean = false) : MangoSeller

val graph = HashMap<PersonNode, List<PersonNode>>().apply {
    put(PersonNode("Gabriele"), listOf(PersonNode("Elena"), PersonNode("Davide"), PersonNode("Gozde")))
    put(
        PersonNode("Elena"),
        listOf(PersonNode("Gabriele"), PersonNode("Ksenia"), PersonNode("Roman"), PersonNode("Sasha"))
    )
    put(PersonNode("Davide"), listOf(PersonNode("Elena"),PersonNode("Greta"), PersonNode("Uzo"), PersonNode("Micheal")))
    put(PersonNode("Gozde"), listOf(PersonNode("Paolo"), PersonNode("Chiara")))
    put(PersonNode("Greta"), listOf(PersonNode("Ciccio", true), PersonNode("Savino")))
    put(PersonNode("Sasha"), listOf(PersonNode("Jose"), PersonNode("Laura")))
    put(PersonNode("Uzo"), listOf(PersonNode("Gianni"), PersonNode("Pippo")))
}

fun <T : MangoSeller> bfs(startNode: T, graph: HashMap<T, List<T>>): T? {
    val queue = ArrayDeque<T>()
    val checkedPeople = hashSetOf(startNode)
    graph[startNode]?.let { queue.addAll(it) }

    while (!queue.isEmpty()) {
        val person = queue.removeFirst()
        checkedPeople.add(person)
        if (person.isMangoSeller) return person
        graph[person]?.let {
            val checkedFriends = it.toMutableList().apply { removeAll(checkedPeople) }
            queue.addAll(checkedFriends)
        }
    }
    return null
}