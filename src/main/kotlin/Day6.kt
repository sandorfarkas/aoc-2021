class Day6(private val input: List<Int> = readInput("day6-input.txt")[0].split(",").map { it.toInt() }) {
	fun first(): Long {
		return calculateUntil(79)
	}

	fun second(): Long {
		return calculateUntil(255)
	}

	private fun calculateUntil(generation: Int): Long {
		val inputText: String = readInput("day6-input.txt")[0].replace(",", "")
		var f8 = parseLong(inputText, '8')
		var f7 = parseLong(inputText, '7')
		var f6 = parseLong(inputText, '6')
		var f5 = parseLong(inputText, '5')
		var f4 = parseLong(inputText, '4')
		var f3 = parseLong(inputText, '3')
		var f2 = parseLong(inputText, '2')
		var f1 = parseLong(inputText, '1')
		var f0 = parseLong(inputText, '0')

		for (i in 0..generation) {
			val pf8 = f8
			val pf0 = f0
			f8 = f0
			f0 = f1
			f1 = f2
			f2 = f3
			f3 = f4
			f4 = f5
			f5 = f6
			f6 = f7 + pf0
			f7 = pf8
		}

		return f8 + f7 + f6 + f5 + f4 + f3 + f2 + f1 + f0
	}

	private fun parseLong(inputText: String, chr: Char) = inputText.count { it == chr }.toLong()
}