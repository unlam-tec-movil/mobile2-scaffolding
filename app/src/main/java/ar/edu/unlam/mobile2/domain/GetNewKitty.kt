package ar.edu.unlam.mobile2.domain

import ar.edu.unlam.mobile2.data.KittiesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewKitty @Inject constructor(var repo: KittiesRepo, var provider: GameProvider) {

    suspend fun getKitty(): String {
        return repo.getNewKittyUrl()
    }

    fun getGame(): Flow<Game> {
        return flow {
            provider.provideGame()
        }
    }
}
