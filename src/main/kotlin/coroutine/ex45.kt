import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


private fun simple(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    simple()
        .map {
            if (it > 2) {
                throw IllegalStateException()
            }
            it + 1
        }
        .catch { e -> emit(-99) }
        .onCompletion { println("Done") }   // collect가 끝난 후 실행
        .collect { value -> println(value) }
}