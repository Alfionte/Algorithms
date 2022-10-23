package custom.data.structures

interface AddableListCallbacks<E> {
    val onValueAdded: (E) -> Unit
    val onClear: () -> Unit
}