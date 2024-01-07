package codingtest

fun main() {
    val answer = solution(
        intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)
    )

    println(answer)

}

private fun solution(topping: IntArray): Int {
    var answer: Int = 0
    val leftMap = mutableMapOf<Int, Int>()
    val rightMap = mutableMapOf<Int, Int>()

    for (i in topping) {
        rightMap[i] = rightMap.getOrDefault(i, 0) + 1
    }

    var cnt: Int = 0
    var anotherCnt: Int = rightMap.count()

    for (i in topping) {
        if (leftMap[i] == null) {
            if (answer > 0) break
            cnt++
            leftMap[i] = 1
        }

        rightMap[i] = rightMap[i]!! - 1
        if (rightMap[i] == 0) anotherCnt--

        if (cnt == anotherCnt) answer++
    }

    return answer
}

//private fun solution(topping: IntArray): Int {
//    var answer: Int = 0
//    val map = mutableMapOf<Int, Int>()
//    val set = mutableSetOf<Int>()
//    var cnt: Int = 0
//
//    for (i in topping) {
//        map[i] = map.getOrDefault(i, 0) + 1
//    }
//
//    var anotherCnt: Int = map.count()
//
//    for ((idx, value) in topping.withIndex()) {
//        if (idx == topping.size - 1) break
//
//        val bool: Boolean = set.add(value)
//        if (bool) {
//            if (answer > 0) break
//            cnt++
//        }
//
//        map[value] = map[value]!! - 1
//        if (map[value] == 0) {
//            anotherCnt--
//        }
//
//        if (cnt == anotherCnt) {
//            answer++
//        }
//    }
//
//    return answer
//}