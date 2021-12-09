class Day9(private val input: List<String> = readInput("day9-input-test.txt")) {
	private val board = input.map { rowInput -> rowInput.toCharArray().map { it.toString().toInt() }.toIntArray() }.toTypedArray()

	fun first(): Int {
		var sum = 0;
		for (x in board[0].indices) {
			for (y in board.indices) {
				if (isLowPoint(x, y)) {
					sum += board[y][x] + 1
				}
			}
		}
		return sum
	}

	private fun isLowPoint(x: Int, y: Int): Boolean {
		val left: Boolean = if (x > 0) board[y][x] < board[y][x - 1] else true
		val right: Boolean = if (x < board[0].size - 1) board[y][x] < board[y][x + 1] else true
		val top: Boolean = if (y > 0) board[y][x] < board[y - 1][x] else true
		val bottom: Boolean = if (y < board.size - 1) board[y][x] < board[y + 1][x] else true
		return left && right && top && bottom
	}

	fun second(): Int {
		val lowPoints = mutableListOf<Coord>()
		for (x in board[0].indices) {
			for (y in board.indices) {
				if (isLowPoint(x, y)) {
					lowPoints.add(Coord(x, y))
				}
			}
		}

		val basinSizes = lowPoints.map { calculateBasinSize(it.x, it.y) }

		val sortedBasinSizes = basinSizes.sorted().reversed()
		return sortedBasinSizes[0] * sortedBasinSizes[1] * sortedBasinSizes[2]
	}

	private fun calculateBasinSize(x: Int, y: Int): Int {
		var open = mutableListOf(Coord(x, y))
		var closed = mutableListOf<Coord>()

		while (open.size > 0) {
			val current = open[0]
			open.addAll(getNeighbors(current.x, current.y)
				.filter { board[it.y][it.x] != 9 && closed.none { c -> c.x == it.x && c.y == it.y } }
				.filter { open.none { c -> c.x == it.x && c.y == it.y } }
			)

			closed.add(current)
			open.removeAt(0)
		}

		return closed.size
	}

	private fun getNeighbors(x: Int, y: Int): MutableList<Coord> {
		val neighbors = mutableListOf<Coord>()
		if (x > 0) {
			neighbors.add(Coord(x - 1, y))
		}
		if (x < board[0].size - 1) {
			neighbors.add(Coord(x + 1, y))
		}
		if (y > 0) {
			neighbors.add(Coord(x, y - 1))
		}
		if (y < board.size - 1) {
			neighbors.add(Coord(x, y + 1))
		}
		return neighbors
	}
}