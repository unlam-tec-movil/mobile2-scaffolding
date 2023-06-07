package ar.edu.unlam.mobile2.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import javax.inject.Inject

class KittiesRestRepo @Inject constructor(builder: Builder) : KittiesRepo {
    var retrofit: Retrofit = builder
        .baseUrl("https://api.thecatapi.com")
        .build()

    override suspend fun getNewKittyUrl(): String {
        var kittyApi = retrofit.create(KittyApi::class.java)

        var call = kittyApi.getKitties()
        val kitties = call.body()

        if (call.isSuccessful) {
            return kitties?.get(0)?.url ?: "no kitties avaiables"
        }

        return "error on call"
    }

    override suspend fun getNewKitty(): Flow<KittyApiModel> {
        val kittyApi = retrofit.create(KittyApi::class.java)

        val call = kittyApi.getKitties()
        val kitties = call.body()

        return flow {
            emit(kitties!![0])
        }
    }
}
