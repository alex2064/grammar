import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {

        // Dispatchers.Unconfined 는 상황에 따라 suspension point가 오면 다른 스레드 할당 가능(일반적으로 사용x)
        async(Dispatchers.Unconfined) {
            println("Unconfined(before) / ${Thread.currentThread().name}")
            delay(1_000L)
            println("Unconfined(after1) / ${Thread.currentThread().name}")
            delay(1_000L)
            println("Unconfined(after2) / ${Thread.currentThread().name}")
        }

    }
}