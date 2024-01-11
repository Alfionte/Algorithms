package usecase

object EvaluateExpressionTreeUseCase : UseCase {
    override fun run() {
        println("--- EvaluateExpressionTreeUseCase ---")

        val tree = BinaryTree(-1).apply {

            left = BinaryTree(-2).apply {
                left = BinaryTree(-4).apply {
                    left = BinaryTree(2)
                    right = BinaryTree(3)
                }
                right = BinaryTree(2)
            }
            right = BinaryTree(-3).apply {
                left = BinaryTree(8)
                right = BinaryTree(3)
            }
        }
        val solution = evaluateExpressionTree(tree)

        println("Expected 6")
        println("found: $solution")
        println()
    }
}


// This is an input class. Do not edit.
open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun evaluateExpressionTree(tree: BinaryTree): Int {
    val value = tree.value
    return when {
        value >= 0 -> value
        value == -1 -> addiction(tree)
        value == -2 -> subtraction(tree)
        value == -3 -> division(tree)
        value == -4 -> multiplication(tree)
        else -> throw IllegalStateException("This value cannot be: $value")
    }
}

private fun addiction(tree: BinaryTree): Int {
    return evaluateExpressionTree(tree.left ?: BinaryTree(0)) + evaluateExpressionTree(tree.right ?: BinaryTree(0))
}

private fun subtraction(tree: BinaryTree): Int {
    return evaluateExpressionTree(tree.left ?: BinaryTree(0)) - evaluateExpressionTree(tree.right ?: BinaryTree(0))
}

private fun division(tree: BinaryTree): Int {
    return evaluateExpressionTree(tree.left ?: BinaryTree(1)) / evaluateExpressionTree(tree.right ?: BinaryTree(1))
}

private fun multiplication(tree: BinaryTree): Int {
    return evaluateExpressionTree(tree.left ?: BinaryTree(1)) * evaluateExpressionTree(tree.right ?: BinaryTree(1))
}
