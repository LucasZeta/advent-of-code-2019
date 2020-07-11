package com.lucaszeta.adventofcode2019.day06

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day06Test {

    @Test
    fun assertControlDataIsCorrect() {
        val testInput = listOf(
                "COM)B",
                "B)C",
                "C)D",
                "D)E",
                "E)F",
                "B)G",
                "G)H",
                "D)I",
                "E)J",
                "J)K",
                "K)L"
        )

        val orbitMapFacility = UniverseOrbitMapFacility(testInput)
        val numberOfOrbits = orbitMapFacility.fetchTotalNumberOfOrbits()

        assertEquals(42, numberOfOrbits)
    }
}