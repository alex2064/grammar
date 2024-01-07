package codingtest

fun main() {
    val answer = solution(
        intArrayOf(2, 3, 3, 5)
    )

    println(answer)
}

private fun solution(numbers: IntArray): IntArray {
    val answer: IntArray = IntArray(numbers.size) { -1 }
    val stack = ArrayDeque<Int>()

    for ((idx, number) in numbers.withIndex()) {
        while (true) {
            if (stack.isEmpty()) {
                stack.addLast(idx)
                break
            }

            val i = stack.last()

            if (numbers[i] < number) {
                answer[i] = number
                stack.removeLast()
            } else {
                stack.addLast(idx)
                break
            }
        }
    }

    return answer
}