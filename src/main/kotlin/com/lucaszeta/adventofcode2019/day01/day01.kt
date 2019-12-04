package com.lucaszeta.adventofcode2019.day01

import kotlin.math.floor

fun calculateFuelNeeded(mass: Int) =
    (floor((mass / 3).toDouble()) - 2).toInt()

fun recursivelyCalculateFuelNeeded(mass: Int): Int {
    val fuel = calculateFuelNeeded(mass)

    return if (fuel <= 0) 0 else fuel + recursivelyCalculateFuelNeeded(fuel)
}

fun main(args: Array<String>) {
    // Part 1
    println(input.map(::calculateFuelNeeded).sum())

    // Part 2
    println(input.map(::recursivelyCalculateFuelNeeded).sum())
}