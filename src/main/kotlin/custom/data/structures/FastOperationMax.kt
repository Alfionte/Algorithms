package custom.data.structures

class FastOperationMax<T : Comparable<T>>(maxDefault: T) : FastOperation<T> {

    var maxValue = maxDefault

    override val onValueAdded: (T) -> Unit = {
        if (it > maxValue) maxValue = it
    }

    override val onClear: () -> Unit = {
        maxValue = maxDefault
    }
}