package com.lucaszeta.adventofcode2019.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class Day08Test {

    @Test
    fun `Should map string into layers`() {
        val input = "123456789012345678901234567890"
        val expectedOutput = listOf(
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0),
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0),
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
        )

        assertEquals(expectedOutput, readLayers(input, 2, 5))
    }

    @Test
    fun `Should find layer with fewest zeros`() {
        val input = listOf(
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0),
                listOf(1, 2, 3, 4, 5, 6, 7, 0, 0, 0),
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 0, 0)
        )
        val expectedOutput = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

        assertEquals(expectedOutput, fetchLayerWithFewest(input, 0))
    }

    @Test
    fun `Should throw exception when not finding layers`() {
        assertThrows<IllegalArgumentException> {
            fetchLayerWithFewest(listOf(), 0)
        }
    }
}
