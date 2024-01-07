import kotlinx.coroutines.*
import kotlin.random.Random

fun main() {
    val scope = CoroutineScope(Dispatchers.Default + CoroutineName("Scope"))
    val job = scope.launch(Dispatchers.IO) {
        launch { printRandom() }
    }

    Thread.sleep(1_000L)
}

private suspend fun printRandom() {
    delay(500L)
    println(Random.nextInt(0, 500))
}