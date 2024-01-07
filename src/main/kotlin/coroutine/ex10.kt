import kotlinx.coroutines.*
import java.lang.Thread.currentThread

fun main() {
    runBlocking {
        doOneTwoThree()
        println("runBlocking: ${Thread.currentThread().name}")
    }
}

private suspend fun doOneTwoThree() = coroutineScope {
    val job1 = launch {
        withContext(NonCancellable) {   // 취소 불가한 job 만들기
            println("launch1: ${Thread.currentThread().name}")
            delay(1_000L)
            println("1")
        }
    }

    val job2 = launch {
        try {
            println("launch2: ${Thread.currentThread().name}")
            delay(1_000L)
            println("2")
        } finally {
            println("job2 is finishing!")
        }
    }

    val job3 = launch {
        try {
            println("launch3: ${Thread.currentThread().name}")
            delay(1_000L)
            println("3")
        } finally {
            println("job3 is finishing!")
        }
    }

    delay(800L)
    job1.cancel()
    job2.cancel()
    job3.cancel()

    println("4")
}