import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {
	private val input = readInput("day4-input-test.txt")

	@Test
	fun firstShouldReturnProperAnswerForTestData() {
		val day4 = Day4(input)

		assertEquals(4512, day4.first())
	}

	@Test
	fun secondShouldReturnProperAnswerForTestData() {
		val day4 = Day4(input)

		assertEquals(1924, day4.second())
	}
}