package ar.edu.unlam.mobile2.domain

import ar.edu.unlam.mobile2.data.KittiesRepo
import ar.edu.unlam.mobile2.data.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

data class Game(
    val question: String = "",
    var correctAnswer: Int = 0,
    val firstOption: String = "",
    val secondOption: String = "",
)

class GameProvider @Inject constructor(val kittiesRepo: KittiesRepo) {
    val builders = listOf(Wider(), Heigher())

    suspend fun provideGame(): Flow<Game> {
        val index = (1..2).random()
        val flowFirst = kittiesRepo.getNewKitty()
        val flowSecond = kittiesRepo.getNewKitty()
        val game = builders[index]

        return flow {
            combine(flowFirst, flowSecond) { firstKitty, secondKitty ->
                {
                    game.BuildGame(firstKitty.toModel(), secondKitty.toModel())
                }
            }
                .collect {
                    emit(
                        it(),
                    )
                }
        }
    }
}
