package codingtest

fun main(){
    val answer = solution(
        arrayOf("mumu", "soe", "poe", "kai", "mine"),
        arrayOf("kai", "kai", "mine", "mine")
    )

    println(answer.toList().toString())
}


private fun solution(players: Array<String>, callings: Array<String>): Array<String> {

    val rank: MutableMap<String, Int> =
        players.mapIndexed { i, player -> player to i }
            .toMap()
            .toMutableMap()

    for (calling in callings) {
        val index = rank[calling]!!
        val chgPlayer = players[index - 1]
        val temp = players[index]
        players[index] = players[index - 1]
        players[index - 1] = temp

        rank[calling] = rank[calling]!! - 1
        rank[chgPlayer] = rank[chgPlayer]!! + 1
    }

    return players
}



//private fun solution(players: Array<String>, callings: Array<String>): Array<String> {
//
//    val rank: MutableMap<String, Int> =
//        players.mapIndexed { i, player -> player to i }
//            .toMap()
//            .toMutableMap()
//
//    for (calling in callings) {
//        rank[calling] = rank[calling]!! - 1
//
//        for ((key, value) in rank) {
//            if (value == rank[calling]) {
//                rank[key] = rank[key]!! + 1
//                break
//            }
//        }
//    }
//
//    players.sortWith(compareBy<String> { rank[it]!! })
//
//    return players
//}

