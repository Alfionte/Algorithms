import usecase.*

val useCaseCollection = listOf(
    BinarySearchUseCase,
    QuickSortUseCase,
    BfsUseCase,
    DijkstraUseCase,
    AddableMaxMinListUseCase,
)

fun main() {
    useCaseCollection.forEach { it.run() }
}