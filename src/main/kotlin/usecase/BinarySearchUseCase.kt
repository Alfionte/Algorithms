package usecase

import binarysearch.binarySearch
import binarysearch.binarySearchImproved

object BinarySearchUseCase : UseCase{

    override fun run(){
        println("--- BinarySearchUseCase ---")

        val list = listOf(0, 1, 2, 4, 5, 9, 12, 3, 56, 79, 88, 96, 111)
        val binarySearch = binarySearch(list, 111)
        val binarySearchImproved = binarySearchImproved(list, 111)

        println("Binary search : found: ${binarySearch.first}, iterations: ${binarySearch.second}")
        println("Binary search improved (best case) : found: ${binarySearchImproved.first}, iterations: ${binarySearchImproved.second}")
        println()
    }
}