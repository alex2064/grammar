import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * collect, reduce, fold, toList, toSet, count과 같은 연산자는 Flow를 끝내는 함수라 종단 연산자(terminal operator)라고 함
 * reduce는 흔히 map과 reduce 로 함께 소개되는 함수형 언어의 오래된 메커니즘
 * 첫번째 값을 결과에 넣은 후 각 값을 가져와 누직적으로 계산
 */
fun main() = runBlocking {
    val value = (1..10).asFlow()
        .reduce { a, b ->
            a + b
        }
    println(value)
}