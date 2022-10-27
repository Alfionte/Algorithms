package usecase

import binarysearch.binarySearch
import ternarysearch.ternarySearch

object TernarySearchUseCase : UseCase {

    override fun run() {
        println("--- TernarySearchUseCase ---")

        val list = (0..10320300).toList()
        val binarySearch = binarySearch(list, 111)
        val ternarySearch = ternarySearch(list, 111, 0)

        println("Binary search : found: ${binarySearch.first}, iterations: ${binarySearch.second}")
        println("Ternary search : found: ${ternarySearch.first}, iterations: ${ternarySearch.second}")
        println()
    }
}