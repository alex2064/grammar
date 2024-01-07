package codingtest

import kotlin.math.sqrt

fun main() {
    val answer = solution(
        "011"
    )

    println(answer)
}

private val useList = mutableListOf<Int>()
private val primeSet = mutableSetOf<Int>()

private fun solution(numbers: String): Int {
    makeNumber(numbers, StringBuilder("0"))

    return primeSet.size
}

private tailrec fun makeNumber(numbers: String, temp: StringBuilder) {
    val number: Int = temp.toString().toInt()
    if (number > 1 && isPrimeNumber(number)) primeSet.add(number)

    if (numbers.length > useList.size) {
        for ((i, value) in numbers.withIndex()) {
            if (useList.contains(i)) continue

            useList.add(i)
            makeNumber(numbers, temp.append(value))
            useList.removeLast()
            temp.deleteCharAt(temp.length - 1)
        }
    }
}

private fun isPrimeNumber(number: Int): Boolean {
    val last = sqrt(number.toDouble()).toInt()
    val set = mutableSetOf<Int>()
    var flag = true

    for (i in 2..last) {
        if (set.contains(i)) continue

        if (number % i == 0) {
            flag = false
            break
        } else {
            (i..last)
                .filter { it % i == 0 }
                .forEach { set.add(it) }
        }
    }

    return flag
}