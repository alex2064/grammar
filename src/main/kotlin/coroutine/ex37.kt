import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    launch(Dispatchers.IO) {
        simple().collect { value -> log("${value}를 받음") }
    }
}

private fun log(msg: String) = println("[${Thread.currentThread().name}] ${msg}")

private fun simple(): Flow<Int> = flow {
    log("flow를 시작합니다.")
    for (i in 1..10) {
        this.emit(i)
    }
}