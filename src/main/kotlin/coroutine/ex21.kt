import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            counter.incrementAndGet()
        }
    }
    println("counter = ${counter}")
}

/**
 * AtomicInteger
 *      - 스레드 안전한 자료구조로 사용하는 방법
 *      - 누가 작업중일때 같이 건드리지 않음
 */
private var counter = AtomicInteger()
private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val elapsed = measureTimeMillis { 
        coroutineScope { 
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("${elapsed} ms 동안 ${n * k}개의 액션을 수행했습니다.")
}