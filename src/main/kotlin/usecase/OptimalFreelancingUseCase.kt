package usecase

object OptimalFreelancingUseCase : UseCase {
    override fun run() {
        println("--- OptimalFreelancingUseCase ---")

        val paymentsReceived = optimalFreelancing(mutableListOf())

        println("Expected 0")
        println("found: $paymentsReceived")
        println()
    }
}


fun optimalFreelancing(jobs: MutableList<Map<String, Int>>): Int {
    val maxArray = Array(7) { 0 }

    jobs.sortByDescending { it.getPayment() }
    jobs.forEach { job ->
        val deadline = job.getDeadline()
        val payment = job.getPayment()
        val index = deadline - 1

        var maxIndex = maxArray[index]
        var isFilled = false
        while (maxIndex >= 0 && !isFilled) {
            if (maxArray[maxIndex] == 0) {
                maxArray[maxIndex] = payment
                isFilled = true
            } else {
                maxIndex--
            }
        }
    }
    return maxArray.sum()
}

private fun Map<String, Int>.getDeadline() = this["deadline"]!!
private fun Map<String, Int>.getPayment() = this["payment"]!!