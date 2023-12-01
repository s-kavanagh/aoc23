package day01

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        for (line in input) {
            val result = line.filter { it.isDigit() }
            count += result.first().digitToInt() * 10
            count += result.last().digitToInt()
        }
        return count
    }

    val textNumberMap = listOf(
        "one" to "one1one",
        "two" to "two2two",
        "three" to "three3three",
        "four" to "four4four",
        "five" to "five5five",
        "six" to "six6six",
        "seven" to "seven7seven",
        "eight" to "eight8eight",
        "nine" to "nine9nine",
    )

    fun part2(input: List<String>): Int {
        var count = 0
        for (line in input) {
            var newLine = line
            // replace strings with ints
            for (item in textNumberMap) {
                newLine = newLine.replace(item.first, item.second)
            }

            val result = newLine.filter { it.isDigit() }
            val one = result.first().digitToInt() * 10
            count += one
            val two = result.last().digitToInt()
            count += two
        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 142)

    // test if implementation meets criteria from the description, like:
    val testInput2 = readInput("day01/Day01_test2")
    check(part2(testInput2) == 281)

    val input = readInput("day01/Day01")
    part1(input).println()
    part2(input).println()
}
