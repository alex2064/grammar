import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


private fun simple(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("emitting $i")
            emit(i) // emit next value
        }
    }.map { value ->
        check(value <= 1) { "crashed on ${value}" } // 예외발생해서 catch에 걸리게 함
        "String ${value}"
    }

fun main() = runBlocking<Unit> {
    simple()    // 업스트림
        .catch { e -> emit("Caught $e") }   // catch는 업스트림에만 영향을 줄 수 있음
        .collect { value -> println(value) }    // 다운스트림
}