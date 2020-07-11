package com.lucaszeta.adventofcode2019.day06

class UniverseOrbitMapFacility(input: List<String>) {

    private val stars = mutableListOf<Star>()

    init {
        input.forEach { coordinate ->
            val (orbitedStarName, orbitingStarName) = coordinate.split(")")

            val orbitedStar = findOrCreateStar(orbitedStarName)
            val orbitingStar = findOrCreateStar(orbitingStarName)

            orbitingStar.orbitedStar = orbitedStar
        }
    }

    private fun findNumberOfStars(star: Star): Int {
        return star.orbitedStar?.let {
            1 + findNumberOfStars(it)
        } ?: 0
    }

    fun fetchTotalNumberOfOrbits() =
            stars.sumBy(::findNumberOfStars)

    private fun findOrCreateStar(starName: String): Star {
        return stars.find { it.name == starName } ?: run {
            stars.add(Star(starName))
            stars.last()
        }
    }
}
