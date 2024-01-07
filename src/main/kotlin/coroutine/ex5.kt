import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {// 코루틴 내에서만 호출되어야함, 함수를 따로 만들어서 호출하면 안됨
            doThree()   // suspension point
        }

        launch {
            doOne()     // suspension point(X)
        }

        doTwo()     // suspension point
    }
    println("4")
}

private suspend fun doThree() {
    println("launch1: ${Thread.currentThread().name}")
    delay(10L)      // suspension point
    println("3")
}

private suspend fun doTwo() {
    println("runBlocking: ${Thread.currentThread().name}")
    delay(1_000L)       // suspension point
    println("2")
}

private fun doOne() {   // delay가 없기 때문에 suspend fun일 필요가 없음
    println("launch2: ${Thread.currentThread().name}")
    println("1")
}

