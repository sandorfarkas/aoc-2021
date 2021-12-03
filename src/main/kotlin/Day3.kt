class Day3(private val input: List<String> = readInput("day3-input.txt")) {
	fun first(): Int {
		val ones = IntArray(input[0].length) { i -> countOnesAtPosition(input, i) }

		var gamma = ""
		var epsilon = ""

		ones.forEach { one ->
			val zero = input.size - one
			gamma = if (one > zero) gamma.plus("1") else gamma.plus("0")
			epsilon = if (one > zero) epsilon.plus("0") else epsilon.plus("1")
		}
		return gamma.toInt(2) * epsilon.toInt(2);
	}

	fun second(): Int {
		val oxygen = input.getRating { ones, zeros -> if (ones >= zeros) '1' else '0' }
		val co2 = input.getRating { ones, zeros -> if (ones >= zeros) '0' else '1' }

		return oxygen.toInt(2) * co2.toInt(2)
	}

	private fun countOnesAtPosition(list: List<String>, atPosition: Int): Int {
		var count = 0;
		list.forEach {
			if (it[atPosition] == '1') count++
		}
		return count
	}

	private fun List<String>.getRating(desiredValue: (ones: Int, zeros: Int) -> Char): String {
		var pos = 0
		var list = this.toList()

		while (list.size > 1) {
			val ones = countOnesAtPosition(list, pos)
			val zeros = list.size - ones
			list = list.filter { it[pos] == desiredValue(ones, zeros) }
			pos++
		}

		return list[0]
	}
}
