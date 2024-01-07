import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.RuntimeException
import kotlin.system.measureTimeMillis


private fun simple(): Flow<Int> =
    flow {
        emit(1)
        throw RuntimeException()
    }

fun main() = runBlocking<Unit> {
    simple()
        .onCompletion { cause ->    // cause를 통해서 문제가 발생한 경우를 알 수 있음, 종료시점에 문제가 있었는지 확인할 수 있음.
            if (cause != null)
                println("Flow completed exceptionally")
            else
                println("Flow completed.")
        }
        .catch { cause -> emit(-99) }
        .collect { value -> println(value) }
}