import usecase.*

val useCaseCollection = listOf(
    BinarySearchUseCase,
    TernarySearchUseCase,
    QuickSortUseCase,
    BfsUseCase,
    DfsUseCase,
    DijkstraUseCase,
    FastListUseCase,
)

fun main() {
    useCaseCollection.forEach { it.run() }
}