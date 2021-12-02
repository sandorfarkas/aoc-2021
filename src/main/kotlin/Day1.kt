class Day1(private val input: List<String> = readInput("day1-input.txt")) {

	fun first(): Int {
		var counter = 0;
		var previousItem = input[0];
		input.forEach {
			if (it.toInt() > previousItem.toInt()) counter++
			previousItem = it
		}
		return counter
	}

	fun second(): Int {
		var counter = 0;
		var previousSum = input[0].toInt() + input[1].toInt() + input[2].toInt()
		for (i in 0..input.size - 3) {
			val sum = input[i].toInt() + input[i + 1].toInt() + input[i + 2].toInt()

			if (sum > previousSum) counter++

			previousSum = sum
		}
		return counter
	}
}

