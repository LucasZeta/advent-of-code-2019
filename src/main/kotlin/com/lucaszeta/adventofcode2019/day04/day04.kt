package com.lucaszeta.adventofcode2019.day04

fun Int.toPassword() = Password(this)

class Password(private val password: Int) {

    private fun hasCorrectAmountOfDigits() = password.toString().length == 6

    private fun hasDoubleDigits() = password.toString().matches("[0-9]?.*(\\d)\\1+[0-9]?.*".toRegex())

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
            hasDoubleDigits() &&
            digitsNeverDecrease()
}

fun main(args: Array<String>) {

    println(input.count { it.toPassword().isValid() })
}