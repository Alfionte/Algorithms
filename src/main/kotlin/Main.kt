import usecase.*

val useCaseCollection = listOf(
    BinarySearchUseCase,
    TernarySearchUseCase,
    QuickSortUseCase,
    BfsUseCase,
    DfsUseCase,
    DijkstraUseCase,
    FastListUseCase,
    TwoNumbersSumUseCase,
    TransposeMatrixUseCase,
    EvaluateExpressionTreeUseCase,
    OptimalFreelancingUseCase,
    MiddleNodeUseCase,
    CommonCharactersUseCase,
)

fun main() {
    useCaseCollection.forEach { it.run() }
}