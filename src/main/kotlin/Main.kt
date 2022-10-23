import usecase.*

val useCaseCollection = listOf(
    BinarySearchUseCase,
    QuickSortUseCase,
    BfsUseCase,
    DfsUseCase,
    DijkstraUseCase,
    FastListUseCase,
)

fun main() {
    useCaseCollection.forEach { it.run() }
}