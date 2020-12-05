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
                listOf(
                        listOf(1, 2, 3, 4, 5),
                        listOf(6, 7, 8, 9, 0)
                ),
                listOf(
                        listOf(1, 2, 3, 4, 5),
                        listOf(6, 7, 8, 9, 0)
                ),
                listOf(
                        listOf(1, 2, 3, 4, 5),
                        listOf(6, 7, 8, 9, 0)
                )
        )

        assertEquals(expectedOutput, readLayers(input, 5, 2))
    }

    @Test
    fun `Should find layer with fewest zeros`() {
        val input = listOf(
                listOf(
                        listOf(1, 2, 3, 0, 5),
                        listOf(6, 7, 8, 9, 0)
                ),
                listOf(
                        listOf(1, 2, 3, 4, 5),
                        listOf(6, 7, 8, 9, 0)
                ),
                listOf(
                        listOf(1, 2, 0, 4, 5),
                        listOf(6, 0, 8, 9, 0)
                )
        )
        val expectedOutput = listOf(
                listOf(1, 2, 3, 4, 5),
                listOf(6, 7, 8, 9, 0)
        )

        assertEquals(expectedOutput, fetchLayerWithFewest(input, 0))
    }

    @Test
    fun `Should throw exception when not finding layers`() {
        assertThrows<IllegalArgumentException> {
            fetchLayerWithFewest(listOf(), 0)
        }
    }

    @Test
    fun `Should find top-most valid pixel in layer list`() {
        val layers = listOf(
                listOf(
                        listOf(0, 2),
                        listOf(2, 2)
                ),
                listOf(
                        listOf(1, 1),
                        listOf(2, 2)
                ),
                listOf(
                        listOf(2, 2),
                        listOf(1, 2)
                ),
                listOf(
                        listOf(0, 0),
                        listOf(0, 0)
                )
        )

        assertEquals(0, findTopPixel(layers, 0, 0))
        assertEquals(1, findTopPixel(layers, 0, 1))
        assertEquals(1, findTopPixel(layers, 1, 0))
        assertEquals(0, findTopPixel(layers, 1, 1))
    }

    @Test
    fun `Should print message based on top-most pixel`() {
        val layers = listOf(
                listOf(
                        listOf(0, 2),
                        listOf(2, 2)
                ),
                listOf(
                        listOf(1, 1),
                        listOf(2, 2)
                ),
                listOf(
                        listOf(2, 2),
                        listOf(1, 2)
                ),
                listOf(
                        listOf(0, 0),
                        listOf(0, 0)
                )
        )

        assertEquals("-O\nO-\n", findMessage(layers, 2, 2))
    }
}
