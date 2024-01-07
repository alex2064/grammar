import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * fold는 reduce와 유사하지만 초기값이 있다는 차이가 있음
 */
fun main() = runBlocking {
    val value = (1..10).asFlow()
        .fold(10) { a, b -> // 초기값 10을 줘서 10 + (1..10) 으로 계산
            a + b
        }
    println(value)
}
