class Day2(private val input: List<String> = readInput("day2-input.txt")) {
	fun first(): Int {
		var x = 0;
		var y = 0;
		input.forEach {
			val command = parseCommand(it)
			when (command.direction) {
				"forward" -> x += command.value
				"down" -> y += command.value
				"up" -> y -= command.value
			}
		}
		return x * y
	}

	fun second(): Int {
		var x = 0;
		var y = 0;
		var aim = 0;
		input.forEach {
			val command = parseCommand(it)
			when (command.direction) {
				"forward" -> {
					x += command.value
					y += command.value * aim
				}
				"down" -> aim += command.value
				"up" -> aim -= command.value
			}
		}
		return x * y
	}

	private fun parseCommand(token: String): Command {
		val tokens = token.split(" ")
		return Command(tokens[0], tokens[1].toInt())
	}
}

class Command(val direction: String, val value: Int)
