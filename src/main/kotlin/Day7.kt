import kotlin.math.abs

class Day7(private val input: List<Int> = readInput("day7-input.txt")[0].split(",").map { it.toInt() }) {
	fun first(): Int {
		var maxX = input.size
		var minX = Integer.MAX_VALUE

		for (i in 0..maxX) {
			val atPos = input.sumOf { abs(it - i) }
			if (atPos < minX) {
				minX = atPos
			}
		}

		return minX
	}

	fun second(): Int {
		var maxX = input.size
		var minX = Integer.MAX_VALUE

		for (i in 0..maxX) {
			val atPos = input.sumOf { calculateSteps(abs(it - i)) }
			if (atPos < minX) {
				minX = atPos
			}
		}

		return minX
	}

	fun calculateSteps(step: Int): Int {
		var sum = 0
		for (i in 1..step) {
			sum += i
		}
		return sum
	}
}