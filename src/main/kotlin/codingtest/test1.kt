package codingtest

fun main(){
    val answer = solution(
        arrayOf("OSO","OOO","OXO","OOO")
        , arrayOf("E 2","S 3","W 1")
    )

    println(answer.toList())
}


private fun solution(park: Array<String>, routes: Array<String>): IntArray {
    val maxRow = park.size
    val maxCol = park[0].length
    var currentRow: Int = -1
    var currentCol: Int = -1
    val parkList = mutableListOf<List<Char>>()

    for ((indexX, str) in park.withIndex()) {
        parkList.add(str.toList())

        if (currentRow == -1) {
            val indexY = str.indexOf('S')
            if (indexY >= 0) {
                currentRow = indexX
                currentCol = indexY
            }
        }
    }

    loop@for (str in routes) {
        val move = str[2].toString().toInt()
        when (str[0]) {
            'N' -> {
                if (currentRow - move < 0) continue@loop

                for (i in 1..move) {
                    if (parkList[currentRow - i][currentCol] == 'X') continue@loop
                }

                currentRow -= move
            }
            'S' -> {
                if (currentRow + move >= maxRow) continue@loop

                for (i in 1..move) {
                    if (parkList[currentRow + i][currentCol] == 'X') continue@loop
                }

                currentRow += move
            }
            'W' -> {
                if (currentCol - move < 0) continue@loop

                for (i in 1..move) {
                    if (parkList[currentRow][currentCol - i] == 'X') continue@loop
                }

                currentCol -= move
            }
            'E' -> {
                if (currentCol + move >= maxCol) continue@loop

                for (i in 1..move) {
                    if (parkList[currentRow][currentCol + i] == 'X') continue@loop
                }

                currentCol += move
            }
        }
    }

    return intArrayOf(currentRow, currentCol)
}