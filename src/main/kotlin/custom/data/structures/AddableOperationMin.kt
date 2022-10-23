package custom.data.structures

class AddableOperationMin<T : Comparable<T>>(minDefault: T) : AddableList.AddableListCallbacks<T> {

    var minValue = minDefault

    override val onValueAdded: (T) -> Unit = {
        if (it < minValue) minValue = it
    }

    override val onClear: () -> Unit = {
        minValue = minDefault
    }
}