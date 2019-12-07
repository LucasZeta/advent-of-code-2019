package com.lucaszeta.adventofcode2019.day03

import kotlin.math.abs

fun List<String>.generatePath(): List<Pair<Int, Int>> {
    val list = mutableListOf(0 to 0)

    forEach { command ->
        val direction = command.take(1)
        val quantity = command.takeLastWhile { it.isDigit() }.toInt()

        repeat(quantity) {
            val lastPoint = list.last()

            val newPoint = when (direction) {
                "R" -> Pair(lastPoint.first + 1, lastPoint.second)
                "L" -> Pair(lastPoint.first - 1, lastPoint.second)
                "U" -> Pair(lastPoint.first, lastPoint.second + 1)
                else -> Pair(lastPoint.first, lastPoint.second - 1)
            }

            list.add(newPoint)
        }
    }

    return list.toList()
}

fun Set<Pair<Int, Int>>.getNearestManhattanDistance(): Int {
    return filter { it != Pair(0, 0) }.map { it.getManhattanDistance() }.sorted().first()
}

fun Pair<Int, Int>.getManhattanDistance(): Int {
    val origin = Pair(0, 0)

    return abs(first - origin.first) + abs(second - origin.second)
}

fun main(args: Array<String>) {

    val path1 = input.first().generatePath()
    val path2 = input.last().generatePath()

    val intersections = path1.intersect(path2)

    // Part 1
    println(intersections.getNearestManhattanDistance())

    // Part 2
    val leastNumberOfSteps = intersections
            .filterNot { it == Pair(0, 0) }
            .map { path1.indexOf(it) + path2.indexOf(it) }
            .sorted()
            .first()

    println(leastNumberOfSteps)
}

