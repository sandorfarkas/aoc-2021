class Day8(private val input: List<String> = readInput("day8-input.txt")) {
	private val signals = Array(input.size) { Array(10) { "" } }
	private val outputs = Array(input.size) { Array(4) { "" } }

	fun first(): Int {
		initData()
		return outputs.sumOf {
			it.count { word -> word.length == 2 || word.length == 4 || word.length == 3 || word.length == 7 }
		}
	}

	private fun initData() {
		input.forEachIndexed { i, it ->
			val parts = it.split("|")
			signals[i] = parts[0].trim().split(" ").toTypedArray()
			outputs[i] = parts[1].trim().split(" ").toTypedArray()
		}
	}

	fun second(): Int {
		initData()
		val allFound = mutableListOf<Int>()

		for (rowIndex in signals.indices) {
			var found = ""
			val signalsRow = signals[rowIndex]
			val map = createMapping(signalsRow)

			val outputRow = outputs[rowIndex]
			outputRow.forEach { word ->
				map.keys.forEach { k ->

					val mapped = k.toCharArray().sortedArray()
					val checked = word.toCharArray().sortedArray()
					if (isTheSame(mapped, checked)) {
						found = found.plus("${map[k]}")
					}
				}
			}
			allFound.add(found.toInt())
		}

		return allFound.sum()
	}

	private fun createMapping(signalsRow: Array<String>): MutableMap<String, Int> {
		val map = mutableMapOf<String, Int>()
		val mapReverse = mutableMapOf<Int, String>()
		for (i in signalsRow.indices) {
			val word = signalsRow[i]
			if (word.length == 2) {
				map[word] = 1
				mapReverse[1] = word
				continue
			}
			if (word.length == 4) {
				map[word] = 4
				mapReverse[4] = word
				continue
			}
			if (word.length == 3) {
				map[word] = 7
				mapReverse[7] = word
				continue
			}
			if (word.length == 7) {
				map[word] = 8
				mapReverse[8] = word
				continue
			}
		}
		for (i in signalsRow.indices) {
			val word = signalsRow[i]
			val one = mapReverse[1]
			val fourMinusOne = mapReverse[4]?.replace("${one?.get(0)}", "")?.replace("${one?.get(1)}", "")
			if (word.length == 5) {

				if (word.toCharArray().sorted().containsAll(mapReverse[1]!!.toCharArray().sorted())) {
					map[word] = 3
					mapReverse[3] = word
					continue
				}

				if (word.toCharArray().sorted().containsAll(fourMinusOne!!.toCharArray().sorted())) {
					map[word] = 5
					mapReverse[5] = word
					continue
				}

				map[word] = 2
				mapReverse[2] = word
			}
		}
		for (i in signalsRow.indices) {
			val word = signalsRow[i]
			if (word.length == 6) {
				if (!word.toCharArray().sorted().containsAll(mapReverse[1]!!.toCharArray().sorted())) {
					map[word] = 6
					mapReverse[6] = word
					continue
				}

				val c = findC(mapReverse[1], mapReverse[2], mapReverse[3], mapReverse[4])

				if (word.toCharArray().sorted().containsAll(mapReverse[5].plus(c).toCharArray().sorted())) {
					map[word] = 9
					mapReverse[9] = word
					continue
				}

				map[word] = 0
				mapReverse[0] = word
			}
		}
		return map
	}

	private fun isTheSame(a: CharArray, b: CharArray): Boolean {
		if (a.size != b.size) return false
		for (i in a.indices) {
			if (a[i] != b[i]) return false
		}
		return true
	}

	private fun findC(s1: String?, s2: String?, s3: String?, s4: String?): Any {
		for (i in 0..s3!!.length) {
			if (s1!!.contains(s3[i]) && s2!!.contains(s3[i]) && s4!!.contains(s3[i])) return s3[i]
		}
		return 'q'
	}
}