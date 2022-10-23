package custom.data.structures

class AddableOperationMax<T : Comparable<T>>(maxDefault: T) : AddableList.AddableListCallbacks<T> {

    var maxValue = maxDefault

    override val onValueAdded: (T) -> Unit = {
        if (it > maxValue) maxValue = it
    }

    override val onClear: () -> Unit = {
        maxValue = maxDefault
    }
}