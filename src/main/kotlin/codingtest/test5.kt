package codingtest

fun main(){
    val answer = solution(
        arrayOf("AN", "CF", "MJ", "RT", "NA"),
        intArrayOf(5, 3, 2, 7, 5)
    )

    println(answer)
}


private fun solution(survey: Array<String>, choices: IntArray): String {
    val mutableMap = mutableMapOf(
        "R" to 0,
        "T" to 0,
        "C" to 0,
        "F" to 0,
        "J" to 0,
        "M" to 0,
        "A" to 0,
        "N" to 0)

    for ((idx, value) in choices.withIndex()) {
        when (value) {
            1,2,3 -> {
                val key = survey[idx][0].toString()
                mutableMap[key] = mutableMap[key]!! + (4 - value)
            }
            5,6,7 -> {
                val key = survey[idx][1].toString()
                mutableMap[key] = mutableMap[key]!! + (value - 4)
            }
        }
    }

    val sb = StringBuilder()
    val answer: String = with(sb) {
        append(if (mutableMap["R"]!! < mutableMap["T"]!!) "T" else "R")
        append(if (mutableMap["C"]!! < mutableMap["F"]!!) "F" else "C")
        append(if (mutableMap["J"]!! < mutableMap["M"]!!) "M" else "J")
        append(if (mutableMap["A"]!! < mutableMap["N"]!!) "N" else "A")
    }.toString()

    return answer
}


