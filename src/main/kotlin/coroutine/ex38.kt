import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun main() = runBlocking<Unit> {
    launch(Dispatchers.IO) {
        simple().collect { value -> log("${value}를 받음") }
    }
}

private fun log(msg: String) = println("[${Thread.currentThread().name}] ${msg}")

private fun simple(): Flow<Int> = flow {
//    withContext(Dispatchers.Default) {    // Flow 내에서는 컨텍스트를 바꿀 수 없음
        for (i in 1..10) {
            delay(100L)
            this.emit(i)
        }
//    }

}