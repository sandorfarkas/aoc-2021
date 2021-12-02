import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day1Test {
	private val input = readInput("day1-input-test.txt").map { it.toInt() }

	@Test
	fun firstShouldReturnProperAnswerForTestData() {
		val day1 = Day1(input)

		assertEquals(7, day1.first())
	}

	@Test
	fun secondShouldReturnProperAnswerForTestData() {
		val day1 = Day1(input)

		assertEquals(5, day1.second())
	}
}