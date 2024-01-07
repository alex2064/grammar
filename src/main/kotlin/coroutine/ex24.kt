import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

private fun flowSomething(): Flow<Int> = flow {
    repeat(10) {
        emit(Random.nextInt(0, 500))    // emit : 스트림(Flow)에 데이터를 흘려보냄
        delay(10L)
    }
}
fun main() = runBlocking {
    flowSomething().collect { value -> println(value) } // 콜드스트림 : collect를 해야 flowSomething이 작동
    // collect는 스트림이 끝날 때 까지 기다리게 됨., collect로는 이벤트를 처리할 수 없음. 이벤트는 몰려오는데 계속 기다리게 하기 때문
    println("Done")
}