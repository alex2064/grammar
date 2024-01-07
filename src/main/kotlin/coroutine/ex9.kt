import kotlinx.coroutines.*
import java.lang.Thread.currentThread

fun main() {
    runBlocking {
        doOneTwoThree()
        println("runBlocking: ${Thread.currentThread().name}")
        println("5")
    }
}

private suspend fun doOneTwoThree() = coroutineScope {
    val job1 = launch { // launch(Dispatchers.Default) 로 하면 다른 쓰레드로 실행해서 취소 불가
        println("launch1: ${Thread.currentThread().name}")
        delay(1_000L)
        println("1")
    }

    val job2 = launch {
        println("launch2: ${Thread.currentThread().name}")
        println("2")
    }

    val job3 = launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(500L)
        println("3")
    }

    delay(800L)
    job1.cancel()   // cancel을 통해서 진행을 그만하고 취소할 수 있음
    job2.cancel()
    job3.cancel()

    println("4")
}