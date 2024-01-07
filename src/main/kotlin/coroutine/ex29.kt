import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..20).asFlow()
        .filter { v -> (v % 2) == 0 }
        .collect {
            println(it)
        }
}