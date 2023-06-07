package ar.edu.unlam.mobile2.domain

class Wider : GameBuilder {
    val question = "Cuál de los dos es más ancho?"

    override fun BuildGame(firstKitty: Kitty, secondKitty: Kitty): Game {
        val firstWidth = firstKitty.width
        val secondWidth = secondKitty.width
        if (firstWidth == 0 || secondWidth == 0) {
            throw InvalidPropertyException("Width missing on one input")
        }

        var correctAnswer = 1

        if (secondWidth > firstWidth) {
            correctAnswer = 2
        }

        return Game(
            correctAnswer = correctAnswer,
            firstOption = firstKitty.url,
            secondOption = secondKitty.url,
            question = question,
        )
    }
}

class Heigher : GameBuilder {
    val question = "Cuál de los dos es más alto?"

    override fun BuildGame(firstKitty: Kitty, secondKitty: Kitty): Game {
        val firstWidth = firstKitty.height
        val secondWidth = secondKitty.height
        if (firstWidth == 0 || secondWidth == 0) {
            throw InvalidPropertyException("Width missing on one input")
        }

        var correctAnswer = 1

        if (secondWidth > firstWidth) {
            correctAnswer = 2
        }

        return Game(
            correctAnswer = correctAnswer,
            firstOption = firstKitty.url,
            secondOption = secondKitty.url,
            question = question,
        )
    }
}
