package com.lucaszeta.adventofcode2019.day08

import java.lang.IllegalArgumentException

fun readLayers(input: String, width: Int, height: Int): List<List<Int>> {
    return input.chunked(width * height) { layer ->
        layer.chunked(1) { it.toString().toInt() }
    }
}

fun fetchLayerWithFewest(layers: List<List<Int>>, number: Int) =
        layers.minBy { layer -> layer.count { it == number } } ?:
                throw IllegalArgumentException("Invalid layers")

fun main() {
    val layers = readLayers(input, 25, 6)
    val layerWithFewestZeros = fetchLayerWithFewest(layers, 0)
    val result = layerWithFewestZeros.count { it == 1 } * layerWithFewestZeros.count { it == 2 }

    println(result)
}
