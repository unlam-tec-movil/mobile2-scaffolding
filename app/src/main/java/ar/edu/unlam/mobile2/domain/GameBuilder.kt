package ar.edu.unlam.mobile2.domain

interface GameBuilder {
    fun BuildGame(firstKitty: Kitty, secondKitty: Kitty): Game
}
