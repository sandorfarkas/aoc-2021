class Day10(private val input: List<String> = readInput("day10-input.txt")) {
	fun first(): Int {
		var penalty = 0
		for (i in input.indices) {
			val stack = ArrayDeque<Char>()
			val row = input[i].toCharArray()
			for (r in row.indices) {
				val checkedChar = row[r]
				if (checkedChar == '(') {
					stack.add('(')
					continue
				}
				if (checkedChar == '[') {
					stack.add('[')
					continue
				}
				if (checkedChar == '{') {
					stack.add('{')
					continue
				}
				if (checkedChar == '<') {
					stack.add('<')
					continue
				}

				if (checkedChar == ')') {
					val topChar = stack.removeLast()
					if (topChar != '(') {
						penalty += 3
					}
					continue
				}
				if (checkedChar == ']') {
					val topChar = stack.removeLast()
					if (topChar != '[') {
						penalty += 57
					}
					continue
				}
				if (checkedChar == '}') {
					val topChar = stack.removeLast()
					if (topChar != '{') {
						penalty += 1197
					}
					continue
				}
				if (checkedChar == '>') {
					val topChar = stack.removeLast()
					if (topChar != '<') {
						penalty += 25137
					}
					continue
				}
			}
		}
		return penalty
	}

	fun second(): Long {
		val scores = mutableListOf<Long>()
		for (i in input.indices) {
			val stack = ArrayDeque<Char>()
			val row = input[i].toCharArray()
			var invalid = false
			for (r in row.indices) {
				val checkedChar = row[r]
				if (checkedChar == '(') {
					stack.add('(')
					continue
				}
				if (checkedChar == '[') {
					stack.add('[')
					continue
				}
				if (checkedChar == '{') {
					stack.add('{')
					continue
				}
				if (checkedChar == '<') {
					stack.add('<')
					continue
				}

				if (checkedChar == ')') {
					val topChar = stack.removeLast()
					if (topChar != '(') {
						invalid = true
						break
					}
					continue
				}
				if (checkedChar == ']') {
					val topChar = stack.removeLast()
					if (topChar != '[') {
						invalid = true
						break
					}
					continue
				}
				if (checkedChar == '}') {
					val topChar = stack.removeLast()
					if (topChar != '{') {
						invalid = true
						break
					}
					continue
				}
				if (checkedChar == '>') {
					val topChar = stack.removeLast()
					if (topChar != '<') {
						invalid = true
						break
					}
					continue
				}
			}
			if (invalid) {
				continue
			} else {
				var score = 0L
				stack.reversed().forEach{
					when(it) {
						'(' -> { score *= 5; score += 1 }
						'[' -> { score *= 5; score += 2 }
						'{' -> { score *= 5; score += 3 }
						'<' -> { score *= 5; score += 4 }
					}
				}
				scores.add(score)
			}
		}

		return scores.sorted()[scores.size/2]
	}
}