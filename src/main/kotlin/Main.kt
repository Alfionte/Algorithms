import usecase.*

val useCaseCollection = listOf(
    BinarySearchUseCase,
    QuickSortUseCase,
    BfsUseCase,
    DijkstraUseCase,
    FastListUseCase,
)

fun main() {
    useCaseCollection.forEach { it.run() }
}