import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        println("launch: ${Thread.currentThread().name}")
        println("World")
    }

    println("runBlocking: ${Thread.currentThread().name}")
    Thread.sleep(500)
    println("Hello")
}

/**
 * Thread.sleep는 스레드를 양보하지 않고 그대로 실행
 * delay는 현재 스레드를 다른 코드가 실행할 수 있게 양보
 */