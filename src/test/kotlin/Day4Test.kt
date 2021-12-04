import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {
	private val testInput = readInput("day4-input-test.txt")
	private val input = readInput("day4-input.txt")

	@Test
	fun firstShouldReturnProperAnswerForTestData() {
		val day4 = Day4(testInput)

		assertEquals(4512, day4.first())
	}

	@Test
	fun secondShouldReturnProperAnswerForTestData() {
		val day4 = Day4(testInput)

		assertEquals(1924, day4.second())
	}

	@Test
	fun firstShouldReturnProperAnswerForGameData() {
		val day4 = Day4(input)

		assertEquals(2745, day4.first())
	}

	@Test
	fun secondShouldReturnProperAnswerForGameData() {
		val day4 = Day4(input)

		assertEquals(6594, day4.second())
	}
}