package custom.data.structures

class FastMutableListImpl<E : Comparable<E>>(
    vararg callbacks: AddableListCallbacks<E>
) : MutableList<E> {

    private val callbackList = callbacks.toList()
    private val list = mutableListOf<E>()
    override val size: Int = list.size

    override fun get(index: Int): E = list[index]

    override fun isEmpty(): Boolean = size == 0

    override fun iterator(): MutableIterator<E> = list.iterator()

    override fun set(index: Int, element: E): E = list.set(index, element).also { update(element) }

    override fun add(element: E): Boolean = list.add(element).also { update(element) }

    override fun add(index: Int, element: E) = list.add(index, element).also { update(element) }

    override fun addAll(elements: Collection<E>): Boolean {
        elements.forEach { add(it) }
        return true
    }

    override fun addAll(index: Int, elements: Collection<E>): Boolean {
        elements.forEach { add(index, it) }
        return true
    }

    override fun clear() = list.clear().also { callbackList.forEach { it.onClear() } }

    override fun remove(element: E): Boolean =
        if (list.remove(element)) {
            updateListAfterRemoval()
            true
        } else false

    override fun removeAt(index: Int): E {
        val removedElement = list.removeAt(index)
        updateListAfterRemoval()
        return removedElement
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        val areRemovedSuccessfully = list.removeAll(elements)
        updateListAfterRemoval()
        return areRemovedSuccessfully
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        val areRetainedSuccessfully = list.retainAll(elements)
        updateListAfterRemoval()
        return areRetainedSuccessfully
    }

    private fun updateListAfterRemoval() {
        val tmpList = list.toList()
        clear()
        addAll(tmpList)
    }

    override fun listIterator() = list.listIterator()

    override fun listIterator(index: Int) = list.listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int) = list.subList(fromIndex, toIndex)

    override fun lastIndexOf(element: E): Int = lastIndexOf(element)

    override fun indexOf(element: E): Int = indexOf(element)

    override fun containsAll(elements: Collection<E>): Boolean = list.containsAll(elements)

    override fun contains(element: E): Boolean = contains(element)

    private fun update(element: E) {
        callbackList.forEach { it.onValueAdded(element) }
    }

    override fun toString(): String = list.toString()
}