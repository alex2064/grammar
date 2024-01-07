package codingtest

import kotlin.math.min

fun main(){
    val answer = solution(
        "5525",
        "1255"
    )

    println(answer)
}


private fun solution(X: String, Y: String): String {
    val xMap: MutableMap<Char, Int> = mutableMapOf<Char, Int>()
    val yMap: MutableMap<Char, Int> = mutableMapOf<Char, Int>()

    for (chr in X) {
        xMap[chr] = (xMap[chr] ?: 0) + 1
    }
    for (chr in Y) {
        yMap[chr] = (yMap[chr] ?: 0) + 1
    }

    val sb = StringBuilder()
    for ( i in 57 downTo 48 ) {
        val key = i.toChar()
        val cnt = min(xMap[key] ?: 0, yMap[key] ?: 0)
        repeat(cnt) {
            sb.append(key)
        }
    }

    val cnt = sb.filter { chr -> chr != '0' }.count()

    return when {
        sb.isEmpty() -> "-1"
        cnt == 0 -> "0"
        else -> sb.toString()
    }
}


//private fun solution(X: String, Y: String): String {
//    val list = mutableListOf<Int>()
//
//    val xMap = mutableMapOf<Char, Int>()
//    X.groupingBy { chr -> chr }.eachCountTo(xMap)
//
//    val yMap = mutableMapOf<Char, Int>()
//    Y.groupingBy { chr -> chr }.eachCountTo(yMap)
//
//    for ((key, value) in xMap) {
//        val cnt = min(value, yMap[key] ?: 0)
//        repeat(cnt) {
//            list.add(key.toString().toInt())
//        }
//    }
//
//    val cnt = list.filter { i -> i != 0 }.count()
//
//    return when {
//        list.size == 0 -> "-1"
//        cnt == 0 -> "0"
//        else -> list.sortedBy { it }.reversed().joinToString("") { it.toString() }
//    }
//}