class Day2(private val input: List<Command> = readInput("day2-input.txt").map { parseCommand(it) }) {
	fun first(): Int {
		var x = 0;
		var y = 0;
		input.forEach {
			when (it.direction) {
				"forward" -> x += it.value
				"down" -> y += it.value
				"up" -> y -= it.value
			}
		}
		return x * y
	}

	fun second(): Int {
		var x = 0;
		var y = 0;
		var aim = 0;
		input.forEach {
			when (it.direction) {
				"forward" -> {
					x += it.value
					y += it.value * aim
				}
				"down" -> aim += it.value
				"up" -> aim -= it.value
			}
		}
		return x * y
	}
}

data class Command(val direction: String, val value: Int)

fun parseCommand(text: String): Command {
	val (d, v) = text.split(" ")
	return Command(d, v.toInt())
}