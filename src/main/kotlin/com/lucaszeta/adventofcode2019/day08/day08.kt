package com.lucaszeta.adventofcode2019.day08

import java.lang.IllegalArgumentException

typealias Layer = List<List<Int>>

fun readLayers(input: String, width: Int, height: Int): List<Layer> {
    return input.chunked(width * height) { layer ->
        layer.chunked(width) { line ->
            line.chunked(1) { it.toString().toInt() }
        }
    }
}

fun fetchLayerWithFewest(layers: List<Layer>, number: Int) =
        layers.minBy { layer -> layer.flatten().count {
            it == number
        }} ?: throw IllegalArgumentException("Invalid layers")

fun main() {
    val width = 25
    val height = 6

    val layers = readLayers(input, width, height)
    val layerWithFewestZeros = fetchLayerWithFewest(layers, 0)
    val result = layerWithFewestZeros.flatten().count { it == 1 } * layerWithFewestZeros.flatten().count { it == 2 }

    println(result)
}
