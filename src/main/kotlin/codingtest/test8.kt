package codingtest

fun main(){
    val answer = solution(
        arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")
    )

    println(answer)
}


private fun solution(babbling: Array<String>): Int {
    val strRegex = "ayaaya|yeye|woowoo|mama".toRegex()
    val strRegex2 = "aya|ye|woo|ma".toRegex()

    return babbling.map { b -> b.replace(strRegex, " ").replace(strRegex2, "") }
        .filter { s -> s.length == 0 }
        .count()
}