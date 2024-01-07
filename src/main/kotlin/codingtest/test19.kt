package codingtest

fun main() {
    val answer = solution(
        1,
        1000000,
        1
    )

    println(answer)
}

var cnt: Int = 1000000
var map = mutableMapOf<Int, Int>()

private fun solution(x: Int, y: Int, n: Int): Int {
    search(x, y, n, 0)
    return if (cnt == 1000000) -1 else cnt
}

private tailrec fun search(x: Int, y: Int, n: Int, depth: Int) {
    val flag = when {
        x == y -> {
            cnt = minOf(cnt, depth)
            false
        }

        (depth >= cnt) || (x > y) || (map[y] ?: depth < depth) -> false
        else -> true
    }

    map[y] = minOf(map[y] ?: depth, depth)
    if (flag) {
        if (y % 3 == 0) search(x, y / 3, n, depth + 1)
        if (y % 2 == 0) search(x, y / 2, n, depth + 1)
        search(x, y - n, n, depth + 1)
    }
}


// 이렇게 가는것 보다 역방향으로 가는게 효율적
//private tailrec fun search(x: Int, y: Int, n: Int, depth: Int) {
//    val flag = when {
//        x == y -> {
//            cnt = minOf(cnt, depth)
//            false
//        }
//
//        depth >= cnt -> false
//        x > y -> false
//        else -> true
//    }
//
//    if (flag) {
//        search(x * 3, y, n, depth + 1)
//        search(x * 2, y, n, depth + 1)
//        search(x + n, y, n, depth + 1)
//    }
//}