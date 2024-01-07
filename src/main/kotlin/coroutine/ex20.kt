import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            counter++
        }
    }
    println("counter = ${counter}")
}

/**
 * @Volatile
 *      - 어떤 스레드에서 실행해도 다른 스레드에 영향을 줌
 *      - 가시성 문제만 해결할 뿐 동시에 읽고 수정해서 생기는 문제는 해결하지 못함
 */
@Volatile   
private var counter = 0
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