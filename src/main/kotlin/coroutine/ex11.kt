import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val elapsedTime = measureTimeMillis {
            val value1 = async {    // 비동기로 호출, 호출이 끝나면 값을 가져오기 위함(async, await 셋트로 사용), 값을 가져올게 없으면 launch 사용
                getRandom1()
            }
            val value2 = async {
                getRandom2()
            }

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