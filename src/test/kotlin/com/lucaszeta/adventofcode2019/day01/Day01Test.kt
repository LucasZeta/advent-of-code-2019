package com.lucaszeta.adventofcode2019.day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun whenReceivingModuleMass_shouldCalculateFuel() {
        assertEquals(2, calculateFuelNeeded(12))
        assertEquals(2, calculateFuelNeeded(14))
        assertEquals(654, calculateFuelNeeded(1969))
        assertEquals(33583, calculateFuelNeeded(100756))
    }

    @Test
    fun whenReceivingModuleMass_shouldCalculateFuelConsideringTheFuelMass() {
        assertEquals(2, recursivelyCalculateFuelNeeded(12))
        assertEquals(2, recursivelyCalculateFuelNeeded(14))
        assertEquals(966, recursivelyCalculateFuelNeeded(1969))
        assertEquals(50346, recursivelyCalculateFuelNeeded(100756))
    }
}