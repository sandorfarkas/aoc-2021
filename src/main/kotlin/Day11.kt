class Day11(private val input: List<String> = readInput("day11-input.txt")) {
	var board = Array(10) { IntArray(10) { 0 } }
	var flashes = 0

	fun first(): Int {
		for (y in input.indices) {
			for (x in input[y].indices) {
				board[y][x] = Character.getNumericValue(input[y][x])
			}
		}

		for (i in 0..99) {
			board = generateNextBoard(board)
		}
		return flashes
	}

	fun second(): Int {
		for (y in input.indices) {
			for (x in input[y].indices) {
				board[y][x] = Character.getNumericValue(input[y][x])
			}
		}

		var count = 0;
		while(!isAllZero(board)) {
			board = generateNextBoard(board)
			count++
		}
		return count
	}

	private fun isAllZero(board: Array<IntArray>): Boolean {
		for (y in board.indices) {
			for (x in board[0].indices) {
				if (board[y][x] != 0) return false
			}
		}
		return true
	}

	private fun generateNextBoard(board: Array<IntArray>): Array<IntArray> {
		val flashed = mutableListOf<Coord>()
		for (y in board.indices) {
			for (x in board[y].indices) {
				board[x][y]++
			}
		}

		while (hasGraterThanNineThatNotFlashed(board, flashed)) {
			for (y in board.indices) {
				for (x in board[0].indices) {
					if (flashed.contains(Coord(x, y))) continue
					if (board[y][x] > 9) {
						if (x > 0 && y > 0) {
							board[y - 1][x - 1]++
						}
						if (y > 0) {
							board[y - 1][x]++
						}
						if (x < board[0].size - 1 && y > 0) {
							board[y - 1][x + 1]++
						}
						if (x > 0) {
							board[y][x - 1]++
						}
						if (x < board[0].size - 1) {
							board[y][x + 1]++
						}
						if (x > 0 && y < board.size - 1) {
							board[y + 1][x - 1]++
						}
						if (y < board.size - 1) {
							board[y + 1][x]++
						}
						if (x < board[y].size - 1 && y < board.size - 1) {
							board[y + 1][x + 1]++
						}
						flashed.add(Coord(x, y))
						flashes++
					}
				}
			}
		}
		flashed.forEach {
			board[it.y][it.x] = 0
		}

		return board
	}

	private fun hasGraterThanNineThatNotFlashed(board: Array<IntArray>, flashed: MutableList<Coord>): Boolean {
		for (y in board.indices) {
			for (x in board[0].indices) {
				if (board[y][x] > 9 && !flashed.contains(Coord(x, y))) return true
			}
		}
		return false
	}
}
