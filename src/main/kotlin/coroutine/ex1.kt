import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {    // 큐에 넣고 후에 실행
        println("step1")
        println(coroutineContext)
        println(Thread.currentThread().name)
    }

    println("step2")
    println(coroutineContext)
    println(Thread.currentThread().name)
}