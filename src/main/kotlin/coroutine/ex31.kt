import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..20).asFlow()
        .transform { value ->
            emit(value)
            emit(someCalc(value))
        }
        .collect {
            println(it)
        }
}

private suspend fun someCalc(i: Int): Int {
    delay(100L)
    return i * 2
}