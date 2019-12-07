package com.lucaszeta.adventofcode2019.day04

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Day04Test {

    @Test
    fun assertNumbersDontDecrease() {
        assertFalse(112343.toPassword().isValid())
        assertTrue(112345.toPassword().isValid())
    }

    @Test
    fun assertAdjacentNumbersDoRepeat() {
        assertFalse(123456.toPassword().isValid())
        assertTrue(123455.toPassword().isValid())
    }

    @Test
    fun assertNumberHaveSixDigits() {
        assertFalse(12234.toPassword().isValid())
        assertTrue(123345.toPassword().isValid())
    }
}