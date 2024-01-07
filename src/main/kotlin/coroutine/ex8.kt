import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.currentThread
import java.time.LocalDateTime

fun main() {
    val cnt = 10_000

    println("doCoroutine START Time: ${LocalDateTime.now()}")
    runBlocking {
        doCoroutine(cnt * 100)
    }
    println("doCoroutine END Time: ${LocalDateTime.now()}")


    println("doNormal START Time: ${LocalDateTime.now()}")
    doNormal(cnt)
    println("doNormal END Time: ${LocalDateTime.now()}")
}

private suspend fun doCoroutine(cnt: Int) = coroutineScope {
    repeat(cnt) { // repeat 수만큼 반복
        launch {
            println("start: ${Thread.currentThread().name}")
            delay(1_000L)
            println("end")
        }    
    }
}

fun doNormal(cnt: Int) {
    for (i in 1..cnt) {
        println("start: ${Thread.currentThread().name}")
        Thread.sleep(1L)
        println("end")
    }
}