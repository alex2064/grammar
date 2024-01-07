package codingtest

import kotlin.math.sqrt

fun main(){
    val answer = solution(
        10, 3, 2
    )

    println(answer)
}


private fun solution(number: Int, limit: Int, power: Int): Int {
    var answer: Int = 0

    for (i in 1..number) {
        answer += powerGauge(i, limit, power)
    }

    return answer
}

private fun powerGauge(number: Int, limit: Int, power: Int): Int {
    var cnt = 0
    for (i in 1..sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) {
            cnt += (if (i * i == number) 1 else 2)
        }
    }

    return if (cnt > limit) power else cnt
}