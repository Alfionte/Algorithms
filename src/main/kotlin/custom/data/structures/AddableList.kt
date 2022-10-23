package custom.data.structures

interface AddableList<E> : List<E> {

    interface AddableListCallbacks<E> {
        val onValueAdded: (E) -> Unit
        val onClear: () -> Unit
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @return `true` because the list is always modified as the result of this operation.
     */
    fun add(element: E): Boolean

    // Bulk Modification Operations
    /**
     * Adds all the elements of the specified collection to the end of this list.
     *
     * The elements are appended in the order they appear in the [elements] collection.
     *
     * @return `true` if the list was changed as the result of the operation.
     */
    fun addAll(elements: Collection<E>): Boolean

    fun clear(): Unit

    // Positional Access Operations
    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @return the element previously at the specified position.
     */
    operator fun set(index: Int, element: E): E

    /**
     * Inserts an element into the list at the specified [index].
     */
    fun add(index: Int, element: E): Unit

    // List Iterators
    override fun listIterator(): MutableListIterator<E>

    override fun listIterator(index: Int): MutableListIterator<E>

    // View
    override fun subList(fromIndex: Int, toIndex: Int): MutableList<E>
}