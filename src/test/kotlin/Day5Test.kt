import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day5Test {
	private val testInput = readInput("day5-input-test.txt").map { parseSegment(it) }
	private val input = readInput("day5-input.txt").map { parseSegment(it) }

	@Test
	fun firstShouldReturnProperAnswerForTestData() {
		val day5 = Day5(testInput)

		Assertions.assertEquals(5, day5.first())
	}

	@Test
	fun secondShouldReturnProperAnswerForTestData() {
		val day5 = Day5(testInput)

		Assertions.assertEquals(12, day5.second())
	}

	@Test
	fun firstShouldReturnProperAnswerForGameData() {
		val day5 = Day5(input)

		Assertions.assertEquals(7674, day5.first())
	}

	@Test
	fun secondShouldReturnProperAnswerForGameData() {
		val day5 = Day5(input)

		Assertions.assertEquals(20898, day5.second())
	}
}