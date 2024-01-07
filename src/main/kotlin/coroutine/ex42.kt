import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    (1..3).asFlow()
        .onEach { delay(100L) }
        .flatMapConcat {    // flatMapConcat, flatMapMerge, flatMapLatest
            requestflow(it)
        }
        .collect {
            println("${it} at ${System.currentTimeMillis() - startTime} ms from start")
        }
}

private fun requestflow(i: Int): Flow<String> = flow {
    emit("$i : First")
    delay(500L)
    emit("$i : Second")
}
