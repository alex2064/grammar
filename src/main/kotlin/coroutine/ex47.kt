import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.RuntimeException
import kotlin.system.measureTimeMillis


private fun events(): Flow<Int> = (1..3).asFlow().onEach { delay(100L) }

private fun log(msg: String) = println("${Thread.currentThread().name} : $msg")

fun main() = runBlocking<Unit> {
    events()
        .onEach { event -> log("Event : $event") }
        .launchIn(this) // 코루틴 스코프, 새로운 코푸틴을 생성
    println("Done")
    // UI작업
    // 네트워크 호출
}