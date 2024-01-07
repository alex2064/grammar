import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

/**
 * Dispatchers.Default
 *      - 코어 수에 비례하는 스레드 풀
 *      - 복잡한 계산을 할때 사용 (CPU 집중 소모)
 *
 * Dispatchers.IO
 *      - 코어 수 보다 훨씬 많은 스레드
 *      - IO 작업을 할때 CPU 소모하지 않으니 코어 수 보다 많은 스레드 생성 가능
 *
 * Dispatchers.Unconfined
 *      - 한번이라도 잠이 들고 나면(delay) 앞으로 어느 스레드에서 실행될지 알 수 없음
 *      - 부모 스레드 말고 외부 스레드가 실행 할 수 있음
 *      - 일반적으로 사용하지 않음
 *
 * newSingleThreadContext(<...>)
 *      - 항상 새로운 스레드 생성
 */
fun main() {
    runBlocking {
        launch {
            println("부모의 콘텍스트 / ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default / ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO / ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined / ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("newSingleThreadContext")) {
            println("newSingleThreadContext / ${Thread.currentThread().name}")
        }



        async {
            println("부모의 콘텍스트 / ${Thread.currentThread().name}")
        }

        async(Dispatchers.Default) {
            println("Default / ${Thread.currentThread().name}")
        }

        async(Dispatchers.IO) {
            println("IO / ${Thread.currentThread().name}")
        }

        async(Dispatchers.Unconfined) {
            println("Unconfined / ${Thread.currentThread().name}")
        }

        async(newSingleThreadContext("newSingleThreadContext")) {
            println("newSingleThreadContext / ${Thread.currentThread().name}")
        }
    }
}