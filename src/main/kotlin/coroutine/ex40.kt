import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


/**
 * collect가 준비되어야 다음 emit을 진행하는데 이런 경우 시간 손실이 생김 100L(생산자) -> 300L(소비자) -> 100L(생산자) -> 300L(소비자) -> 100L(생산자) -> 300L(소비자)
 * 이런 경우 소비자 측에 buffer를 두고 생산자 측에는 collect가 준비된지 신경쓰지 않고 일단 보냄 100L(생산자) -> 100L(생산자) -> 100L(생산자)
 * 그러면 소비자 측에서 자신의 속도대로 처리해나감
 */
fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple()
            .buffer()   // 생산자 측(simple)에서는 자기가 emit  
            .collect {
                delay(300L)
                println(it)
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