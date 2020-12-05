package com.lucaszeta.adventofcode2019.day08

import java.lang.IllegalArgumentException

typealias Layer = List<List<Int>>

const val BLACK = 0
const val WHITE = 1

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

fun findTopPixel(layers: List<Layer>, x: Int, y: Int): Int {
    return layers.map {
        it[y][x]
    }.first {
        it == BLACK || it == WHITE
    }
}

fun findMessage(layers: List<Layer>, width: Int, height: Int): String {
    var message = ""

    for (y in 0 until height) {
        for (x in 0 until width) {
            val pixel = findTopPixel(layers, x, y)

            message += if (pixel == BLACK) "-" else "O"
        }

        message += "\n"
    }

    return message
}

fun main() {
    val width = 25
    val height = 6

    val layers = readLayers(input, width, height)
    val layerWithFewestZeros = fetchLayerWithFewest(layers, 0)
    val result = layerWithFewestZeros.flatten().count { it == 1 } * layerWithFewestZeros.flatten().count { it == 2 }

    println("Multiplication of layer with fewest zeros: %d".format(result))
    println("Message:\n%s".format(findMessage(layers, width, height)))
}
