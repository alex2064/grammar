import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

private fun flowSomething(): Flow<Int> = flow {
    repeat(10) {
        emit(Random.nextInt(0, 500))    // emit : 스트림(Flow)에 데이터를 흘려보냄
        delay(10L)
    }
}
fun main() = runBlocking {
    flowSomething()
        .map { "$it $it" }
        .collect { value -> println(value) }
}