import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
//	println("~= Day 1 =~")
//	val day1 = Day1()
//	println(day1.first())
//	println(day1.second())
//
//	println("~= Day 2 =~")
//	val day2 = Day2()
//	println(day2.first())
//	println(day2.second())

//	println("~= Day 3 =~")
//	val day3 = Day3()
//	println(day3.first())
//	println(day3.second())

	println("~= Day 4 =~")
	val day4 = Day4()
	println(day4.first())
	println(day4.second())

}

fun readInput(filename: String): List<String> = Path("./src/main/resources/$filename").readLines()