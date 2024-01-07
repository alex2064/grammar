import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.random.Random

private fun flowSomething(): Flow<Int> = flow {
    repeat(10) {
        emit(Random.nextInt(0, 500))    // emit : 스트림(Flow)에 데이터를 흘려보냄
        delay(100L)
    }
}
fun main() = runBlocking {
    val result = withTimeoutOrNull(500L) {
        flowSomething().collect { value -> println(value) }
        true
    } ?: false

    if (!result) {
        println("취소되었습니다.")
    }
}