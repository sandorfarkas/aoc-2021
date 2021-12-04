class Day4(private val input: List<String> = readInput("day4-input.txt")) {
	private val bingo = Bingo(
		input[0].split(",").map { it.toInt() },
		input.slice(2 until input.size).windowed(5, 6).map { boardOf(it) }
	)

	fun first(): Int {
		for(drawIndex in 5 until bingo.draws.size) {
			bingo.board.forEach{board->
				if (board.isBingo(bingo.draws.slice(0..drawIndex))) {
					return bingo.draws[drawIndex] * board.notDrawnSum(bingo.draws.slice(0..drawIndex))
				}
			}
		}
		return -1
	}

	fun second(): Int {
		class DrawBoard(val boardIndex: Int, val drawIndex: Int)

		val wins: MutableList<DrawBoard> = mutableListOf()

		for(i in 5 until bingo.draws.size) {
			bingo.board.forEachIndexed{index, b->
				if (b.isBingo(bingo.draws.slice(0..i))) {
					wins.add(DrawBoard(index, i))
				}
			}
		}

		val winBoards: MutableList<Int> = mutableListOf()

		wins.forEach{
			if (it.boardIndex !in winBoards ) {
				winBoards.add(it.boardIndex)
			}
		}

		val drawBoard = wins.find { db -> db.boardIndex.equals(winBoards.last()) }

		return bingo.draws[drawBoard!!.drawIndex] * bingo.board[drawBoard.boardIndex].notDrawnSum(bingo.draws.slice(0..drawBoard.drawIndex))
	}
}

class Bingo(val draws: List<Int>, val board: List<Board>)

class Board(private val numbers: Array<IntArray>) {
	fun isBingo(draws: List<Int>): Boolean {
		numbers.forEach { row ->
			if (draws.containsAll(row.toList())) return true
		}
		for (i in 0..4) {
			val column = listOf(numbers[0][i], numbers[1][i], numbers[2][i], numbers[3][i], numbers[4][i])
			if (draws.containsAll(column)) return true
		}
		return false
	}

	fun notDrawnSum(draws: List<Int>): Int {
		var sum = 0
		numbers.forEach { row ->
			row.forEach { n ->
				if (n !in draws) {
					sum += n
				}
			}
		}
		return sum
	}
}

fun boardOf(input: List<String>): Board {
	val numbers = Array(5) { IntArray(5) }
	input.forEachIndexed { index, it ->
		val row = it.trim().split("\\s+".toRegex()).map { i -> i.toInt() }.toIntArray()
		numbers[index] = row
	}
	return Board(numbers)
}