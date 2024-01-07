import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.currentThread

fun main() {
    runBlocking {
        doOneTwoThree()
        println("runBlocking: ${Thread.currentThread().name}")
        println("5")
    }
}

private suspend fun doOneTwoThree() = coroutineScope {  // 부모는 자식이 모두 끝날때까지 기다림
    val job = launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(10L)  // suspension point, 스레드를 양보할 대상이 없으면 그냥 대기
        println("1")
    }
    job.join()  // suspension point, job이 수행이 끝날때 까지 대기

    launch {
        println("launch2: ${Thread.currentThread().name}")
        println("2")
    }

    launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(1_000L)
        println("3")
    }

    println("4")
}