import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
	println("~= Day 9 =~")
	val day9 = Day9()
	println(day9.first())
	println(day9.second())

//	println("~= Day 7 =~")
//	val day7 = Day7()
//	println(day7.first())
//	println(day7.second())

//	println("~= Day 6 =~")
//	val day6 = Day6()
//	println(day6.first())
//	println(day6.second())

//	println("~= Day 5 =~")
//	val day5 = Day5()
//	println(day5.first())
//	println(day5.second())

//	println("~= Day 4 =~")
//	val day4 = Day4()
//	println(day4.first())
//	println(day4.second())

//	println("~= Day 3 =~")
//	val day3 = Day3()
//	println(day3.first())
//	println(day3.second())

//	println("~= Day 2 =~")
//	val day2 = Day2()
//	println(day2.first())
//	println(day2.second())

//	println("~= Day 1 =~")
//	val day1 = Day1()
//	println(day1.first())
//	println(day1.second())
}

fun readInput(filename: String): List<String> = Path("./src/main/resources/$filename").readLines()