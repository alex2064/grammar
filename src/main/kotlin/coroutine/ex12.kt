import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val elapsedTime = measureTimeMillis {
            val value1 = async(start = CoroutineStart.LAZY) {
                getRandom1()
            }
            val value2 = async(start = CoroutineStart.LAZY) {
                getRandom2()
            }

            // async(start = CoroutineStart.LAZY)로 선언한 경우 start해주지 않으면 큐에 안올라감
            value1.start()  // 큐에 수행 예약
            value2.start()

            // .await() : 결과를 받아옴
            println("${value1.await()} + ${value2.await()} = ${value1.await() + value2.await()}")
        }

        println(elapsedTime)
    }
}

private suspend fun getRandom1(): Int {
    delay(1_000L)
    return Random.nextInt(0, 500)
}

private suspend fun getRandom2(): Int {
    delay(1_000L)
    return Random.nextInt(0, 500)
}