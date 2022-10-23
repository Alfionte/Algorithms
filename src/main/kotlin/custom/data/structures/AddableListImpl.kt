package custom.data.structures

class AddableListImpl<E : Comparable<E>>(
    val onValueAdded: (E) -> Unit = {},
    val onClear: () -> Unit = {}
) : AddableList<E> {

    private val list = mutableListOf<E>()
    override val size: Int = list.size

    override fun get(index: Int): E = list[index]

    override fun isEmpty(): Boolean = size == 0

    override fun iterator(): Iterator<E> = list.iterator()

    override fun set(index: Int, element: E): E = list.set(index, element).also { update(element) }

    override fun add(element: E): Boolean = list.add(element).also { update(element) }

    override fun add(index: Int, element: E) = list.add(index, element).also { update(element) }

    override fun addAll(elements: Collection<E>): Boolean {
        elements.forEach { add(it) }
        return true
    }

    override fun clear() = list.clear().also { onClear() }

    override fun listIterator() = list.listIterator()

    override fun listIterator(index: Int) = list.listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int) = list.subList(fromIndex, toIndex)

    override fun lastIndexOf(element: E): Int = lastIndexOf(element)

    override fun indexOf(element: E): Int = indexOf(element)

    override fun containsAll(elements: Collection<E>): Boolean = list.containsAll(elements)

    override fun contains(element: E): Boolean = contains(element)

    private fun update(element: E) {
        onValueAdded(element)
    }

    override fun toString(): String = list.toString()
}