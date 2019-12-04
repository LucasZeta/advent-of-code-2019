package com.lucaszeta.adventofcode2019.day02

class IntCode(private val list: MutableList<Int>) {

    private var currentIndex = 0

    fun findResult(noun: Int, verb: Int): List<Int> {
        list[1] = noun
        list[2] = verb

        var result = listOf<Int>()

        while (hasNext()) {
            result = process()
        }

        return result
    }

    private fun process(): List<Int> {
        val opcode = list[currentIndex]
        val firstIndex = list[currentIndex + 1]
        val secondIndex = list[currentIndex + 2]
        val resultIndex = list[currentIndex + 3]

        when (opcode) {
            1 -> list[resultIndex] = list[firstIndex] + list[secondIndex]
            2 -> list[resultIndex] = list[firstIndex] * list[secondIndex]
            99 -> currentIndex = list.size
            else -> throw IllegalArgumentException("Unknown opcode $opcode")
        }

        next()

        return list.toList()
    }

    private fun hasNext() = currentIndex + 4 <= list.size

    private fun next() {
        currentIndex += 4
    }
}

fun main(args: Array<String>) {

    // Part 1
    val intCode = IntCode(input.toMutableList())
    println(intCode.findResult(12, 2))

    // Part 2
    val expectedResult = 19690720

    for (noun in 0..99) {
        for (verb in 0..99) {
            val result = IntCode(input.toMutableList()).findResult(noun, verb)

            if (result.first() == expectedResult) {
                println(100 * noun + verb)
                return
            }
        }
    }
}