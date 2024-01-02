package usecase

object TransposeMatrixUseCase : UseCase {
    override fun run() {
        println("--- TransposeMatrixUseCase ---")

        val solution = transposeMatrix(matrix = mutableListOf(
            mutableListOf(1,2),
            mutableListOf(3,4),
        ))

        println("Expected [1, 3]")
        println("         [2, 4]")
        println("found: $solution")
        println()
    }
}


fun transposeMatrix(matrix: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {

    val transposedMatrix = mutableListOf<MutableList<Int>>()
    val columns = matrix[0].size

    for (columnIndex in 0 until columns) {
        transposedMatrix.add(mutableListOf())
    }


    matrix.forEachIndexed{ lineIndex, line ->
        line.forEachIndexed { columnIndex, value ->
            transposedMatrix[columnIndex].add(value)
        }
    }
    return transposedMatrix
}
