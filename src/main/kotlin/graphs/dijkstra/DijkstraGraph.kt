package graphs.dijkstra

import graphs.Node

@JvmInline
value class Name(val nodeName: String)

@JvmInline
value class Distance(val distance: Int)

val dijkstraGraph = HashMap<Node<Name>, HashMap<Node<Name>, Distance>>().apply {
    put(
        Node(Name("start")),
        hashMapOf(
            Node(Name("a")) to Distance(2),
            Node(Name("b")) to Distance(5),
        )
    )
    put(
        Node(Name("a")),
        hashMapOf(
            Node(Name("b")) to Distance(8),
            Node(Name("c")) to Distance(7),
        )
    )
    put(
        Node(Name("b")),
        hashMapOf(
            Node(Name("c")) to Distance(2),
            Node(Name("d")) to Distance(4),
        )
    )
    put(
        Node(Name("c")),
        hashMapOf(
            Node(Name("finish")) to Distance(1),
        )
    )
    put(
        Node(Name("d")),
        hashMapOf(
            Node(Name("c")) to Distance(6),
            Node(Name("finish")) to Distance(3),
        )
    )
    put(
        Node(Name("finish")),
        hashMapOf()
    )
}