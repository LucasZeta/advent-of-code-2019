package com.lucaszeta.adventofcode2019.day04

fun Int.toPassword() = Password(this)

class Password(private val password: Int) {

    private fun hasCorrectAmountOfDigits() = password.toString().length == 6

    private fun hasRepeatedDigits() = password.toString().matches("[0-9]?.*(\\d)\\1+[0-9]?.*".toRegex())

    private fun hasDoubleDigits(): Boolean {
        val result = "(\\d)\\1+".toRegex().findAll(password.toString())

        return result.any { it.value.length == 2 }
    }

    private fun digitsNeverDecrease(): Boolean {
        val digits = password.toString()
                .split("")
                .filter { it.isNotBlank() }
                .map { it.toInt() }

        for (index in 1 until digits.size) {
            if (digits[index] < digits[index - 1]) {
                return false
            }
        }

        return true
    }

    fun isValid() = hasCorrectAmountOfDigits() &&
            hasRepeatedDigits() &&
            digitsNeverDecrease()

    fun enhancedIsValid() = hasCorrectAmountOfDigits() &&
            hasDoubleDigits() &&
            digitsNeverDecrease()
}

fun main(args: Array<String>) {

    // Part 1
    println(input.count { it.toPassword().isValid() })

    // Part 2
    println(input.count { it.toPassword().enhancedIsValid() })
}