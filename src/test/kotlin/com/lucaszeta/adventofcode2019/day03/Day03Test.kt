package com.lucaszeta.adventofcode2019.day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun generatePath_shouldReadUpCommand() {
        val expectedPoints = listOf(
                0 to 0,
                0 to 1,
                0 to 2
        )
        assertEquals(expectedPoints, listOf("U2").generatePath())
    }

    @Test
    fun generatePath_shouldReadRightCommand() {
        val expectedPoints = listOf(
                0 to 0,
                1 to 0,
                2 to 0
        )
        assertEquals(expectedPoints, listOf("R2").generatePath())
    }

    @Test
    fun generatePath_shouldReadDownCommand() {
        val expectedPoints = listOf(
                0 to 0,
                0 to -1,
                0 to -2
        )
        assertEquals(expectedPoints, listOf("D2").generatePath())
    }

    @Test
    fun generatePath_shouldReadLeftCommand() {
        val expectedPoints = listOf(
                0 to 0,
                -1 to 0,
                -2 to 0
        )
        assertEquals(expectedPoints, listOf("L2").generatePath())
    }

    @Test
    fun getManhattanDistance_shouldCalculateDistanceBetweenPointsAndOrigin() {
        assertEquals(5, Pair(1, 4).getManhattanDistance())
        assertEquals(8, Pair(2, 6).getManhattanDistance())
        assertEquals(4, Pair(2, 2).getManhattanDistance())
    }

    @Test
    fun getManhattanDistance_shouldCalculateDistanceBetweenNegativePoints() {
        assertEquals(5, Pair(-1, 4).getManhattanDistance())
        assertEquals(8, Pair(2, -6).getManhattanDistance())
        assertEquals(4, Pair(-2, -2).getManhattanDistance())
    }
}