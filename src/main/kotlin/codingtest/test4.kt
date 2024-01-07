package codingtest

fun main(){
    val answer = solution(
        intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)
    )

    println(answer)
}


private fun solution(ingredient: IntArray): Int {
    var answer: Int = 0
    val list = mutableListOf<Int>()

    for (i in ingredient) {
        list.add(i)
        if (list.size >= 4) {
            answer += checkList(list, list.size)
        }
    }

    return answer
}

private fun checkList(list: MutableList<Int>, len: Int): Int =
    if (list[len - 4] == 1 && list[len - 3] == 2 && list[len - 2] == 3 && list[len - 1] == 1) {
        repeat(4) {
            list.removeAt(list.size - 1)
        }
        1
    } else {
        0
    }
