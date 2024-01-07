import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * count는 조건을 만족하는 갯수 출력
 */
fun main() = runBlocking {
    val value = (1..10).asFlow()
        .count { it % 2 == 0 }  // 종단연산자, terminal operator. 특정 값, 컬렉션. 결과
        // .filter 와 같은 것들은 중간 연산자, 결과 X
    println(value)
}
