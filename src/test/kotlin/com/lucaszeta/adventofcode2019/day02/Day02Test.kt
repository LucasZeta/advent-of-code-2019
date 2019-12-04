package com.lucaszeta.adventofcode2019.day02

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun whenReceivingModuleMass_shouldCalculateFuel() {
        val sampleInput = listOf(1,0,0,3,2,3,11,0,99,30,40,50)
        val expectedOutput = listOf(3500,9,10,70,2,3,11,0,99,30,40,50)

        assertEquals(
                expectedOutput,
                IntCode(sampleInput.toMutableList()).findResult(9, 10)
        )
    }
}