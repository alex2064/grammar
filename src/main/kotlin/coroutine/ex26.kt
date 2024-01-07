import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    flowOf(1, 2, 3, 4, 5).collect {// Flow에 emit으로 1, 2, 3, 4, 5를 넣어주는 것과 같음 emit(1), emit(2)...
        println(it)
    }
}