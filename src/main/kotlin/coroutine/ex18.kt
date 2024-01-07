import kotlinx.coroutines.*
import kotlin.random.Random

fun main() {
    runBlocking {
        val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + ceh)  // SupervisorJob()은 예외가 발생했을때 자신의 자식으로만 취소를 전달
        val job1 = scope.launch { printRandom1() }
        val job2 = scope.launch { printRandom2() }
        joinAll(job1, job2)

        println("main")
        Thread.sleep(1_000L)
    }
}


private val ceh = CoroutineExceptionHandler { _, exception ->   // ceh는 renBlocking 안에서는 동작 안함
    println("Something happend: ${exception}")
}

private suspend fun printRandom1() {
    println("printRandom1")
    delay(1_000L)
    println(Random.nextInt(0, 500))
}

private suspend fun printRandom2() {
    println("printRandom2")
    delay(500L)
    throw ArithmeticException()
}