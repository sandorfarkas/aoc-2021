class Day1(private val input: List<Int> = readInput("day1-input.txt").map { it.toInt() }) {

	fun first(): Int {
		return countIncrease(input)
	}

	fun second(): Int {
		return countIncrease(input.windowed(3) { it.sum() })
	}

	private fun countIncrease(input: List<Int>): Int {
		return input
			.windowed(2)
			.count { (a, b) -> b > a }
	}
}

