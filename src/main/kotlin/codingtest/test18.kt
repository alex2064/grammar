package codingtest

fun main() {
    val answer = solution(
        5,
        5,
        intArrayOf(2, 2, 2, 2, 1, 1, 1, 1, 1)
    )

    println(answer)
}

private fun solution(bridgeLength: Int, weight: Int, truckWeights: IntArray): Int {
    val deque = ArrayDeque<Int>()
    var sum = 0
    var cnt = 0

    while (deque.size < bridgeLength) {
        deque.addLast(0)
    }

    // 일단 모든 데이터 디큐에 넣기
    for (wgt in truckWeights) {
        deque.removeFirst()
        sum = deque.sum()

        while (weight < sum + wgt) {
            deque.addLast(0)
            cnt++
            deque.removeFirst()
            sum = deque.sum()
        }
        deque.addLast(wgt)
        cnt++
    }

    while (deque.sum() > 0) {
        deque.removeFirst()
        cnt++
    }

    return cnt
}
