import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple().collectLatest {    // 처리하다가 다른값이 오면 바로 캔슬하고 마지막에 온 값으로 처리
            println("값 ${it}를 처리하기 시작합니다.")
            delay(300L)
            println(it)
            println("처리를 완료하였습니다.")
        }
    }
    println("Collected in ${time} ms")
}

private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100L)
        emit(i)
    }
}