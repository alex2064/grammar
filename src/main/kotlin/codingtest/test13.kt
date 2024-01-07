package codingtest




fun main(){
    val answer = solution(
        arrayOf("banana", "apple", "rice", "pork", "pot"),
        intArrayOf(3, 2, 2, 2, 1),
        arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")
    )

    println(answer)
}


private fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
    var answer: Int = 0
    val numberArr = number.copyOf()
    val wantMap = mutableMapOf<String, Int>()

    for ((i, item) in want.withIndex()) {
        wantMap[item] = i
    }

    for ((i, item) in discount.withIndex()) {
        if (i >= 10) {
            val minusItem = discount[i - 10]
            val idx = wantMap[minusItem]
            if (idx != null) numberArr[idx]++
        }

        val idx = wantMap[item] ?: continue
        numberArr[idx]--

        if (numberArr.filter { it > 0 }.isEmpty()) answer++
    }

    return answer
}