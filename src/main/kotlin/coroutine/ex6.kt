import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Thread.currentThread

/**
 * runBlocking : 현재 스레드를 멈추게 만들고 기다리게함
 * coroutineScope : 현재 스레드를 멈추지 않고 다른 일을 할게 있으면 하게 함
 */
fun main() {
    runBlocking {
        doOneTwoThree()
    }
}

/**
 * 함수를 따로 만들어 launch를 쓸때는 coroutineScope로 감싸줘야함
 */
private suspend fun doOneTwoThree() = coroutineScope {
    this.launch {
        println("launch1: ${Thread.currentThread().name}")
        delay(10L)
        println("1")
    }

    this.launch {
        println("launch2: ${Thread.currentThread().name}")
        println("2")
    }

    this.launch {
        println("launch3: ${Thread.currentThread().name}")
        delay(1_000L)
        println("3")
    }

    println("4")
}