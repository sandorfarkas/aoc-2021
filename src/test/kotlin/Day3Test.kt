import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day3Test {
	private val input = readInput("day3-input-test.txt")

	@Test
	fun firstShouldReturnProperAnswerForTestData() {
		val day3 = Day3(input)

		assertEquals(198, day3.first())
	}

	@Test
	fun secondShouldReturnProperAnswerForTestData() {
		val day3 = Day3(input)

		assertEquals(230, day3.second())
	}
}