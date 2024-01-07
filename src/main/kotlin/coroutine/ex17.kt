import kotlinx.coroutines.*
import kotlin.random.Random

fun main() {
    val scope = CoroutineScope(Dispatchers.IO)
    val job = scope.launch(ceh) {
        launch { printRandom1() }
        launch { printRandom2() }
    }

    println("main")
    Thread.sleep(1_000L)
}


private val ceh = CoroutineExceptionHandler { _, exception ->   // ceh는 runBlocking 안에서는 동작 안함
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