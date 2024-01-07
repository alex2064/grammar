import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..20).asFlow()
        .transform { value ->
            emit(value)
            emit(someCalc(value))
        }
        .take(5)    // Flow에 값을 5개만 가지고옴
        // .drop(5)     // 처음 5개 버림
        .collect {
            println(it)
        }
}

private suspend fun someCalc(i: Int): Int {
    delay(100L)
    return i * 2
}