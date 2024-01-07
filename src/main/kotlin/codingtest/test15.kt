package codingtest

fun main() {
    val answer = solution(
        "EIO"
    )

    println(answer)
}

private fun solution(word: String): Int {
    var answer = 0

    val chrArr = charArrayOf('A', 'E', 'I', 'O', 'U')
    val intArr = intArrayOf(781, 156, 31, 6, 1)

    for ((idx, value) in word.withIndex()) {
        answer += intArr[idx] * chrArr.indexOf(value)
    }
    answer += word.length
    return answer
}