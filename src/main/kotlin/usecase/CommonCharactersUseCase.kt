package usecase

object CommonCharactersUseCase : UseCase {
    override fun run() {
        println("--- CommonCharactersUseCase ---")

        val result = commonCharacters(mutableListOf("abc", "bcd", "cbad"))

        println("Expected [b, c]")
        println("found: $result")
        println()
    }
}

fun commonCharacters(strings: MutableList<String>): List<String> {
    when (strings.size) {
        0 -> return emptyList()
        1 -> return strings.first().toCharArray().map { it.toString() }
        else -> {
            var firstMap: MutableMap<Char, Int> = strings.first().toCharArray().associateWith { 0 }.toMutableMap()

            for (i in 1..strings.lastIndex) {
                val currentString = strings[i]
                currentString.forEach { char ->
                    if (firstMap.contains(char)) {
                        firstMap[char] = i
                    }
                }
                firstMap = firstMap.filter { it.value == i }.toMutableMap()
            }
            return firstMap.filter { it.value == strings.lastIndex }.map { it.key.toString() }
        }
    }
}
