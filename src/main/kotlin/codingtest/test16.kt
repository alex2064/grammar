package codingtest

fun main() {
    val answer = solution(
        longArrayOf(11)
    )

    println(answer)
}

private fun solution(numbers: LongArray): LongArray {
    var answer = arrayListOf<Long>()

    for (number in numbers) {
        val str: String = number.toString(2)
        val lastZero: Int = str.indexOfLast { it == '0' }

        when (lastZero) {
            (str.length - 1) -> answer.add(number + 1)

            -1 -> {
                val incStr = "10" + str.substring(1)
                answer.add(incStr.toLong(2))
            }

            else -> {
                val incStr = str.substring(0, lastZero) + "10" + str.substring(lastZero + 2)
                answer.add(incStr.toLong(2))
            }
        }
    }

    return answer.toLongArray()
}


//private fun solution(numbers: LongArray): LongArray {
//    var answer = arrayListOf<Long>()
//
//    for (number in numbers) {
//        var incNumber: Long = number + 1
//        while ((number xor incNumber).countOneBits() > 2) {
//            incNumber++
//        }
//        answer.add(incNumber)
//    }
//
//    return answer.toLongArray()
//}