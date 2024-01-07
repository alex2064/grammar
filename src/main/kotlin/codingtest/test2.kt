package codingtest

import kotlin.math.min

fun main(){
    val answer = solution(
        arrayOf("ABACD", "BCEFD")
        , arrayOf("ABCD","AABB")
    )

    println(answer.toList())
}


private fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
    val answer = mutableListOf<Int>()
    val map = mutableMapOf<Char, Int>()

    for (key in keymap) {
        for ((idx, value) in key.withIndex()) {
            val cnt = idx + 1
            map[value] = min(map[value] ?: cnt, cnt)
        }
    }

    for (target in targets) {
        var sum = 0
        for (chr in target.toList()) {
            if (map[chr] == null) {
                sum = -1
                break
            }
            sum += map[chr]!!
        }
        answer.add(sum)
    }

    return answer.toIntArray()
}