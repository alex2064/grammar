package codingtest

import kotlin.math.sqrt

fun main() {
    val answer = solution(
        arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 0, 0, 1),
            intArrayOf(1, 1, 1, 1)
        )
    )

    println(answer)

}

private fun solution(arr: Array<IntArray>): IntArray {
    var oneCnt = 0
    var zeroCnt = 0
    var size = arr.size
    while (size > 0) {
        for (i in arr.indices step size) {
            loop@for (j in arr.indices step size) {
                val base = arr[i][j]
                if (base !in 0..1) continue@loop

                for (k in i until i + size) {
                    for (l in j until j + size) {
                        if (base != arr[k][l]) continue@loop
                    }
                }

                for (k in i until i + size) {
                    for (l in j until j + size) {
                        arr[k][l] = -1
                    }
                }
                if (base == 1) oneCnt++ else zeroCnt++
                arr[i][j] = size
            }
        }
        size /= 2
    }

    return intArrayOf(zeroCnt, oneCnt)
}