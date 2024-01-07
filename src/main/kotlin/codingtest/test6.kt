package codingtest

fun main(){
    val answer = solution(
        "abracadabra"
    )

    println(answer)
}


private fun solution(s: String): Int {
    var answer: Int = 0

    var chr = ' '
    var cnt = 0
    for (c in s) {
        when (chr) {
            ' ', c -> {
                cnt++
                chr = c
            }
            else -> {
                cnt--
            }
        }

        if (cnt == 0) {
            answer++
            chr = ' '
        }
    }

    if (cnt > 0) answer++

    return answer
}

