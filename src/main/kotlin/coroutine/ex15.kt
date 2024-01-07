@file:OptIn(ExperimentalStdlibApi::class)

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        async(Dispatchers.Default + CoroutineName("async1")) {
            println("Thread.currentThread().name / ${Thread.currentThread().name}")
            println("coroutineContext[CoroutineDispatcher] / ${coroutineContext[CoroutineDispatcher]}")
            println("coroutineContext[CoroutineName] / ${coroutineContext[CoroutineName]}")
        }
    }
}