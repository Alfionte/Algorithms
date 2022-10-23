package custom.data.structures

interface FastOperation<E> {
    val onValueAdded: (E) -> Unit
    val onClear: () -> Unit
}