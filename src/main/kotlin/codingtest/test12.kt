package codingtest



fun main(){
    val answer = solution(
        intArrayOf(7, 9, 1, 1, 4)
    )

    println(answer)
}


private fun solution(elements: IntArray): Int {
    val intSet = elements.toMutableSet()
    val intArr = elements.copyOf()
    val size = elements.size

    for (i in 1 until size) {
        for (idx in intArr.indices) {
            val nextIdx = (idx + i) % size
            intArr[idx] += elements[nextIdx]
            intSet.add(intArr[idx])
        }
    }

    val answer: Int = intSet.size
    return answer
}