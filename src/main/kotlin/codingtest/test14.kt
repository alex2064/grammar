package codingtest

import kotlin.math.max

fun main() {
    val answer = solution(
        80,
        arrayOf(
            intArrayOf(80, 20),
            intArrayOf(50, 40),
            intArrayOf(30, 10)
        )
    )

    println(answer)
}

private fun solution(k: Int, dungeons: Array<IntArray>): Int {
    var answer: Int = -1
    val useDungeons: MutableSet<Int> = mutableSetOf<Int>()

    answer = searchDungeons(k, dungeons, useDungeons)

    return answer
}

private fun searchDungeons(
    fatigue: Int,
    dungeons: Array<IntArray>,
    useDungeons: MutableSet<Int>
): Int {
    var cnt: Int = 0
    for ((idx, intArr) in dungeons.withIndex()) {
        if (useDungeons.contains(idx)) continue

        val limit = intArr[0]
        val cost = intArr[1]
        if (fatigue >= limit) {
            useDungeons.add(idx)
            cnt = max(cnt, searchDungeons(fatigue - cost, dungeons, useDungeons) + 1)
            useDungeons.remove(idx)
        }
    }

    // 여러개의 기준으로 정렬하려면 아래의 소스 참고
    // val sortedData = dungeons.sortedWith(compareBy({ it[0] }, { it[1] }))
    return cnt
}