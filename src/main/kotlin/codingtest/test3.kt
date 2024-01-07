package codingtest

fun main(){
    val answer = solution(
        "aukks",
        "wbqd",
        5
    )

    println(answer)
}


private fun solution(s: String, skip: String, index: Int): String {
    var answer: String = ""
    val chrs = ('a'..'z').filter { chr -> !skip.contains(chr) }
    val len = chrs.size

    for (chr in s) {
        val idx = chrs.indexOf(chr)
        val nextIdx = (idx + index) % len
        answer += chrs[nextIdx]
    }

    return answer
}