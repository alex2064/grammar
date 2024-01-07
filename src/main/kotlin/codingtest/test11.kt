package codingtest



fun main(){
    val answer = solution(
        6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    )

    println(answer)
}


private fun solution(k: Int, tangerine: IntArray): Int {
    var answer: Int = 0
    val map: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

    for (i in tangerine) {
        map[i] = (map[i] ?: 0) + 1
    }

    val countList = map.values.toList().sortedDescending()

    var cnt = 0
    for ((idx, value) in countList.withIndex()) {
        cnt += value
        if (k <= cnt) {
            answer = idx + 1
            break
        }
    }

    return answer
}

//private fun solution(k: Int, tangerine: IntArray): Int {
//    var answer: Int = 0
//    val map = tangerine.asIterable().groupingBy { it }.eachCount()
//    val countList = map.values.toList().sorted().reversed()
//
//    var cnt = 0
//    for ((idx, value) in countList.withIndex()) {
//        cnt += value
//        if (k <= cnt) {
//            answer = idx + 1
//            break
//        }
//    }
//
//    return answer
//}