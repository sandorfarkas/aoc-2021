import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day2Test {
	private val input = readInput("day2-input-test.txt")

	@Test
	fun firstShouldReturnProperAnswerForTestData() {
		val day2 = Day2(input)

		assertEquals(150, day2.first())
	}

	@Test
	fun secondShouldReturnProperAnswerForTestData() {
		val day2 = Day2(input)

		assertEquals(900, day2.second())
	}
}