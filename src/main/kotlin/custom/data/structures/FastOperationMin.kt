package custom.data.structures

class FastOperationMin<T : Comparable<T>>(minDefault: T) : FastOperation<T> {

    var minValue = minDefault

    override val onValueAdded: (T) -> Unit = {
        if (it < minValue) minValue = it
    }

    override val onClear: () -> Unit = {
        minValue = minDefault
    }
}