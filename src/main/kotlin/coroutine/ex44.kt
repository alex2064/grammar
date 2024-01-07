import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


private fun simple(): Flow<Int> = (1..3).asFlow()

/**
 * Flow가 모두 완료되었을때 다음 작업을 실행하는 전통적인 코딩 방식 try...finally
 */
fun main() = runBlocking<Unit> {
    try {
        simple().collect { value -> println(value) }
    } finally {
        println("Done")
    }
}