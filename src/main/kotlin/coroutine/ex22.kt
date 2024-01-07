import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            /**
             * mutex.withLock
             *      - 임계영역에 한번에 한 스레드만 진입할 수 있고 하나가 진입하면 나머지는 대기
             *      - 동시성 제어
             */
            mutex.withLock {
                counter++
            }
        }
    }
    println("counter = ${counter}")
}

private val mutex = Mutex()
private var counter = 0

private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100     // 시작할 코루틴의 갯수
    val k = 1000    // 코루틴 내에서 반복할 횟수
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