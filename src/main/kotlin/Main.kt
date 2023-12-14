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
)

fun main() {
    useCaseCollection.forEach { it.run() }
}