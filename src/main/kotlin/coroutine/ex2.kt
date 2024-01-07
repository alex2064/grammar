import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {    // 큐에 넣고 후에 실행
        println("launch: ${Thread.currentThread().name}")
        delay(1)    // suspension point, 중단점
        println("World")
    }

    println("runBlocking: ${Thread.currentThread().name}")
    delay(1)    // delay를 하는 순간 runBlocking이 스레드를 양보해서 launch 실행됨
    println("Hello")
}