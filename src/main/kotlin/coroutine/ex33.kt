import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..20).asFlow()
        .transform { value ->
            emit(value)
            emit(someCalc(value))
        }
        .takeWhile {    // 조건에 만족하는 동안까지만 가져옴
            it > 15
        }
//        .dropWhile {    // 조건에 만족하면 버림
//            it == 15
//        }
        .collect {
            println(it)
        }
}

private suspend fun someCalc(i: Int): Int {
    delay(100L)
    return i * 2
}