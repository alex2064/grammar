fun main() {
    val value: String? = "ABC"
    printStr(value)

    val names: List<String> = listOf("kim", "park", "lee")
    names.forEach { println(it) }

}

fun printStr(value: String?) {
    if (value == null) {
        val str: String? = value
        println(str)
    } else {
        val str: String = value
        println(str)
    }
}