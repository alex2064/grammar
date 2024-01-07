import kotlinx.coroutines.*
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit> {

    val counter = this.counterActor()
    withContext(Dispatchers.Default) {
        massiveRun {
            counter.send(IncCounter)
        }
    }

    val response = CompletableDeferred<Int>()
    counter.send(GetCounter(response))
    println("Counter = ${response.await()}")
    counter.close()
}

sealed class CounterMsg
object IncCounter : CounterMsg()  // 값을 증가시키는 싱글톤 클래스
class GetCounter(   // 값을 가져오는 클래스
    val response: CompletableDeferred<Int>
) : CounterMsg()

/**
 * actor를 만들어서 그 액터를 호출해서 동시성 제어
 */
fun CoroutineScope.counterActor(): SendChannel<CounterMsg> = actor<CounterMsg> {
    var counter = 0 // 액터 안에 상태를 캡슐화해두고 다른 코루틴이 접근하지 못하게 막음 

    for (msg in channel) {  // 외부에서 보내는 것은 채널을 통해서만 수신 가능
        when (msg) {
            is IncCounter -> counter++
            is GetCounter -> msg.response.complete(counter)
            else -> {}
        }
    }
}

private suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100     // 시작할 코루틴의 갯수
    val k = 1000    // 코루틴 내에서 반복할 횟수
    val elapsed = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) {
                        action()
                    }
                }
            }
        }
    }
    println("${elapsed} ms 동안 ${n * k}개의 액션을 수행했습니다.")
}