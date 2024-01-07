import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


fun main() = runBlocking<Unit> {
    simple().collect { value -> // 다운스트림
        log("${value}를 받음")
    }
}

private fun log(msg: String) = println("[${Thread.currentThread().name}] ${msg}")

private fun simple(): Flow<Int> = flow {
    for (i in 1..10) {
        delay(100L)
        log("값 ${i}를 emit합니다.")
        emit(i)
    }   // 업스트림
}.flowOn(Dispatchers.Default)   // flow가 구동될 dispatcher 선택(업스트림만 해당)
    .map { it * 2 } // 다운스트림(flowOn 이후의 것은 flowOn의 dispatcher 설정 적용 안됨)