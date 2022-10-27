package usecase

import binarysearch.binarySearch
import binarysearch.binarySearchImproved
import ternarysearch.ternarySearch

object TernarySearchUseCase : UseCase {

    override fun run() {
        println("--- TernarySearchUseCase ---")

        val list = (0..10320300).toList()
        val binarySearch = binarySearch(list, 10320299)
        val binarySearchImproved = binarySearchImproved(list, 10320299)
        val ternarySearch = ternarySearch(list, 10320299, 0)

        println("Binary search : found: ${binarySearch.first}, iterations: ${binarySearch.second}")
        println("Binary search improved (best case) : found: ${binarySearchImproved.first}, iterations: ${binarySearchImproved.second}")
        println("Ternary search : found: ${ternarySearch.first}, iterations: ${ternarySearch.second}")
        println()
    }
}