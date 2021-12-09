class Day5(private val input: List<Segment> = readInput("day5-input.txt").map { parseSegment(it) }) {
	private val xWidth = input.maxOf { it.maxX() } + 1
	private val yWidth = input.maxOf { it.maxY() } + 1

	fun first(): Int {
		val board = Array(yWidth) { IntArray(xWidth) { 0 } }
		input.forEach {
			registerCoords(it.getCoords(), board)
		}
		return calculateSum(board)
	}

	fun second(): Int {
		val board = Array(yWidth) { IntArray(xWidth) { 0 } }
		input.forEach {
			registerCoords(it.getCoords(), board)
			registerCoords(it.getCoordsWithDiagonal(), board)
		}
		return calculateSum(board)
	}

	private fun calculateSum(board: Array<IntArray>): Int {
		var sum = 0
		board.forEach { row ->
			row.forEach { n ->
				if (n >= 2) {
					sum++
				}
			}
		}
		return sum
	}
}

private fun registerCoords(coords: List<Coord>, board: Array<IntArray>) {
	coords.forEach {
		board[it.y][it.x]++
	}
}

fun parseSegment(line: String): Segment {
	val parts = line.split(" -> ")
	val first = parts[0].split(",")
	val second = parts[1].split(",")
	return Segment(first[0].toInt(), first[1].toInt(), second[0].toInt(), second[1].toInt())
}

class Segment(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {
	fun maxX() = if (x1 > x2) x1 else x2
	fun maxY() = if (y1 > y2) y1 else y2

	fun getCoords(): List<Coord> {
		val coords = mutableListOf<Coord>()
		if (x1 == x2) {
			if (y1 < y2) {
				for (i in y1..y2) {
					coords.add(Coord(x1, i))
				}
			} else {
				for (i in y1 downTo y2) {
					coords.add(Coord(x1, i))
				}
			}
		}
		if (y1 == y2) {
			if (x1 < x2) {
				for (i in x1..x2) {
					coords.add(Coord(i, y1))
				}
			} else {
				for (i in x1 downTo x2) {
					coords.add(Coord(i, y1))
				}
			}
		}
		return coords
	}

	fun getCoordsWithDiagonal(): List<Coord> {
		val coords = mutableListOf<Coord>()
		if (x1 != x2 && y1 != y2) {
			if (x1 < x2) {
				if (y1 < y2) {
					for (i in x1..x2) {
						coords.add(Coord(i, y1 + (i - x1)))
					}
				} else {
					for (i in x1..x2) {
						coords.add(Coord(i, y1 - (i - x1)))
					}
				}
			} else {
				if (y1 < y2) {
					for (i in x1 downTo x2) {
						coords.add(Coord(i, y1 + (x1 - i)))
					}
				} else {
					for (i in x1 downTo x2) {
						coords.add(Coord(i, y1 - (x1 - i)))
					}
				}
			}
		}
		return coords
	}
}

class Coord(val x: Int, val y: Int) {
	override fun equals(other: Any?): Boolean {
		if (other !is Coord) return false
		return this.x == other.x && this.y == other.y
	}
}